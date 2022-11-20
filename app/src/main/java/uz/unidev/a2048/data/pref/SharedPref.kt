package uz.sultandev.a2048.data.pref

interface SharedPref {

    fun getBestScorePuzzle2048(): Int

    fun setBestScorePuzzle2048(bestScore: Int)

    fun getMatrixPuzzle2048(): Array<Array<Int>>

    fun setMatrixPuzzle2048(matrix: Array<Array<Int>>)

    fun getCurrentScorePuzzle2048(): Int

    fun setCurrentScorePuzzle2048(currentScore: Int)

    fun getMusic():Boolean

    fun setMusic(music:Boolean)

}