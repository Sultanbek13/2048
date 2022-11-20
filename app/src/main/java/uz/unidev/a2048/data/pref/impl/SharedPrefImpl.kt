package uz.sultandev.a2048.data.pref.impl

import android.content.SharedPreferences
import uz.sultandev.a2048.data.pref.SharedPref
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefImpl @Inject constructor(private val sharedPref: SharedPreferences) : SharedPref {

    private val editor = sharedPref.edit()

    private var matrix = arrayOf(
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0)
    )

    override fun getBestScorePuzzle2048(): Int = sharedPref.getInt(BEST_SCORE_PUZZLE_2048, 0)

    override fun setBestScorePuzzle2048(bestScore: Int) {
        editor.putInt(BEST_SCORE_PUZZLE_2048, bestScore).apply()
    }

    override fun getMatrixPuzzle2048(): Array<Array<Int>> {
        return matrix
    }

    override fun setMatrixPuzzle2048(matrix: Array<Array<Int>>) {
        this.matrix = matrix
    }

    override fun getCurrentScorePuzzle2048(): Int = sharedPref.getInt(CURRENT_SCORE_PUZZLE_2048, 0)

    override fun setCurrentScorePuzzle2048(currentScore: Int) {
        editor.putInt(CURRENT_SCORE_PUZZLE_2048, currentScore).apply()
    }

    override fun getMusic(): Boolean = sharedPref.getBoolean(MUSIC, true)

    override fun setMusic(music: Boolean) = editor.putBoolean(MUSIC, music).apply()

    companion object {
        const val BEST_SCORE_PUZZLE_2048 = "best_score_2048"
        const val CURRENT_SCORE_PUZZLE_2048 = "current_score_2048"
        const val MUSIC = "music"
    }
}