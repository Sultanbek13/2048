package uz.sultandev.a2048.ui.fragment.game

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.sultandev.a2048.R
import com.sultandev.a2048.databinding.FragmentGameBinding
import com.sultandev.a2048.ui.dialog.GameOverDialog
import com.sultandev.a2048.ui.dialog.GameWinDialog
import com.sultandev.a2048.ui.fragment.game.impl.GameViewModelImpl
import com.sultandev.a2048.utils.Constants
import com.sultandev.a2048.utils.MovementDetector
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : Fragment(R.layout.fragment_game) {

    private val binding: FragmentGameBinding by viewBinding(FragmentGameBinding::bind)

    private val itemList = ArrayList<TextView>()

    private lateinit var player: MediaPlayer

    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.currentScore.observe(this, scoreObserver)
        viewModel.changePosition.observe(this, changePositionObserver)
        viewModel.bestScore.observe(this, bestScoreObserver)
        viewModel.gameOver.observe(this, gameOverObserver)
        viewModel.winnerLiveData.observe(this, winnerObserver)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        player = MediaPlayer.create(requireContext(), R.raw.music_app)

        viewModel.musicLiveData.observe(viewLifecycleOwner,musicObserver)

        binding.imgRefresh.setOnClickListener {
            viewModel.refresh()
            startAnimZoomIn(it)
        }

        val detector = MovementDetector(requireContext())

        detector.setOnMovementListener {
            viewModel.move(it)
        }

        binding.headerContainer.setOnTouchListener(detector)

        viewModel.currentMatrix.observe(viewLifecycleOwner, matrixObserver)

    }

    override fun onDestroyView() {
        viewModel.quitGame()
        if (player.isPlaying) {
            player.stop()
        }
        super.onDestroyView()
    }

    private val matrixObserver = Observer<Array<Array<Int>>> {
        for (i in it.indices) {
            for (j in it[i].indices) {
                val view = itemList[i * it.size + j]
                val value = it[i][j]
                view.apply {
                    text = if (value == 0) ""
                    else "$value"
                    setBackgroundResource(Constants.getBackground(value))
                }
            }
        }
    }

    private val scoreObserver = Observer<Int> {
        binding.tvCurrentScore.text = it.toString()
    }

    private val changePositionObserver = Observer<Pair<Int, Int>> {
        val player = MediaPlayer.create(requireContext(), R.raw.click_sound)
        player.start()
        startAnimZoomIn(itemList[it.first * 4 + it.second])
        viewModel.addScore(it)
    }

    private val bestScoreObserver = Observer<Int> {
        binding.tvRecordScore.text = it.toString()
    }

    private val gameOverObserver = Observer<Unit> {
        val dialog = GameOverDialog(requireContext())
        dialog.setFinishListener {
            dialog.dismiss()
            viewModel.refresh()
            findNavController().navigateUp()
        }
        dialog.setRetryListener {
            dialog.dismiss()
            viewModel.refresh()
        }
        dialog.show()
    }

    private val winnerObserver = Observer<Unit> {
        val dialog = GameWinDialog(requireContext())
        dialog.setFinishListener {
            dialog.dismiss()
            viewModel.refresh()
            findNavController().navigateUp()
        }
        dialog.setRetryListener {
            dialog.dismiss()
            viewModel.refresh()
        }
        dialog.show()
    }

    private fun initView() {
        val container = binding.headerContainer
        val size = container.childCount
        for (i in 0 until size) {
            val group: ViewGroup = container.getChildAt(i) as ViewGroup
            for (j in 0 until size) {
                val view = group.getChildAt(j) as TextView
                itemList.add(view)
            }
        }
    }

    private fun startAnimZoomIn(view: View) {
        YoYo.with(Techniques.ZoomIn)
            .delay(0)
            .duration(100)
            .playOn(view)
    }

    private val musicObserver = Observer<Boolean> {
        if(it) {
            player.start()
            player.isLooping = true
        }
    }
}