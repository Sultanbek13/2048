package com.sultandev.a2048.data.repository.impl

import com.sultandev.a2048.data.pref.SharedPref
import com.sultandev.a2048.data.repository.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val sharedPref: SharedPref) : GameRepository {

    override fun getMatrix() = sharedPref.getMatrixPuzzle2048()

    override fun setMatrix(matrix: Array<Array<Int>>) {
        sharedPref.setMatrixPuzzle2048(matrix)
    }

    override fun getBestScore(): Int = sharedPref.getBestScorePuzzle2048()

    override fun setBestScore(score: Int) = sharedPref.setBestScorePuzzle2048(score)

    override fun setCurrentScore(currentScore: Int) {
        sharedPref.setCurrentScorePuzzle2048(currentScore)
    }

    override fun getCurrentScore() =
        sharedPref.getCurrentScorePuzzle2048()

    override fun getMusic()  = sharedPref.getMusic()
}