package com.sultandev.a2048.data.pref.impl

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sultandev.a2048.data.pref.SharedPref
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefImpl @Inject constructor(private val sharedPref: SharedPreferences): SharedPref {

    private val editor = sharedPref.edit()
    private val gson = Gson()

    override fun getBestScorePuzzle2048(): Int = sharedPref.getInt(BEST_SCORE_PUZZLE_2048, 0)

    override fun setBestScorePuzzle2048(bestScore: Int) {
        editor.putInt(BEST_SCORE_PUZZLE_2048, bestScore).apply()
    }

    override fun getMatrixPuzzle2048(): Array<Array<Int>> {
        val type = object : TypeToken<Array<Array<Int>>>() {}.type
        val gsonString =
            sharedPref.getString(MATRIX_PUZZLE_2048, "[[0,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,0]]")
        return gson.fromJson(gsonString, type)
    }

    override fun setMatrixPuzzle2048(matrix: Array<Array<Int>>) {
        val type = object : TypeToken<Array<Array<Int>>>() {}.type
        val gsonString = gson.toJson(matrix, type)
        editor.putString(MATRIX_PUZZLE_2048, gsonString).apply()
    }

    override fun getCurrentScorePuzzle2048(): Int = sharedPref.getInt(CURRENT_SCORE_PUZZLE_2048, 0)

    override fun setCurrentScorePuzzle2048(currentScore: Int) {
        editor.putInt(CURRENT_SCORE_PUZZLE_2048, currentScore).apply()
    }

    override fun getMusic(): Boolean = sharedPref.getBoolean(MUSIC, true)

    override fun setMusic(music: Boolean) = editor.putBoolean(MUSIC, music).apply()

    companion object {
        const val SHARED_NAME = "app_data"
        const val BEST_SCORE_PUZZLE_2048 = "best_score_2048"
        const val MATRIX_PUZZLE_2048 = "matrix_puzzle_2048"
        const val CURRENT_SCORE_PUZZLE_2048 = "current_score_2048"

        const val MUSIC = "music"
    }
}