package com.sultandev.a2048.ui.fragment.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.sultandev.a2048.R
import com.sultandev.a2048.databinding.FragmentMenuBinding
import com.sultandev.a2048.ui.MainActivity
import com.sultandev.a2048.ui.dialog.GameOverDialog
import com.sultandev.a2048.ui.dialog.setting.SettingDialog
import com.sultandev.a2048.ui.fragment.menu.impl.MenuViewModelImpl
import com.sultandev.a2048.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding: FragmentMenuBinding by viewBinding()
    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.playGameClickLiveData.observe(this, playGameClickObserver)
        viewModel.infoClickLiveData.observe(this, infoClickObserver)
        viewModel.settingClickLiveData.observe(this, settingClickObserver)
        viewModel.shareClickLiveData.observe(this, shareClickObserver)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.iconGame.setOnClickListener {
            viewModel.onClickPlayGame()
            startAnimZoomIn(it)
        }

        binding.iconSetting.setOnClickListener {
            viewModel.onSettingClick()
            startAnimZoomIn(it)
        }

        binding.iconInfo.setOnClickListener {
            viewModel.onInfoClick()
            startAnimZoomIn(it)
        }

        binding.iconShare.setOnClickListener {
            viewModel.onShareClick()
            startAnimZoomIn(it)
        }
    }

    private val playGameClickObserver = Observer<Unit> {
        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToGameFragment())
    }

    private val infoClickObserver = Observer<Unit> {
        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToInfoFragment())
    }

    private val settingClickObserver = Observer<Unit> {
        val dialog = SettingDialog()
        dialog.show(requireActivity().supportFragmentManager, "")
    }

    private val shareClickObserver = Observer<Unit> {
        Constants.shareApp(requireActivity() as MainActivity)
    }

    private fun startAnimZoomIn(view: View) {
        YoYo.with(Techniques.ZoomIn)
            .delay(0)
            .duration(500)
            .playOn(view)
    }
}