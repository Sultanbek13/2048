package uz.sultandev.a2048.data.repository

interface GameRepository {

    fun getMatrix(): Array<Array<Int>>

    fun setMatrix(matrix: Array<Array<Int>>)

    fun getBestScore(): Int

    fun setBestScore(score: Int)

    fun setCurrentScore(currentScore:Int)

    fun getCurrentScore():Int

    fun getMusic():Boolean

}