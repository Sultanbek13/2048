package uz.sultandev.a2048.ui.fragment.game

import androidx.lifecycle.LiveData
import com.sultandev.a2048.data.model.Movement

interface GameViewModel {

    val bestScore: LiveData<Int>

    val currentScore: LiveData<Int>

    val changePosition: LiveData<Pair<Int, Int>>

    val gameOver: LiveData<Unit>

    val winnerLiveData: LiveData<Unit>

    val currentMatrix: LiveData<Array<Array<Int>>>

    val musicLiveData: LiveData<Boolean>

    fun move(movement: Movement)

    fun refresh()

    fun addScore(pair: Pair<Int,Int>)

    fun quitGame()

}