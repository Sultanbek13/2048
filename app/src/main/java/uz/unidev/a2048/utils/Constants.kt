package uz.sultandev.a2048.utils

import android.content.Intent
import com.sultandev.a2048.R
import com.sultandev.a2048.ui.MainActivity

object Constants {
    private val backgroundList = listOf(
        R.drawable.bg_header,
        R.drawable.default_background,
        R.drawable.bg_4,
        R.drawable.bg_8,
        R.drawable.bg_16,
        R.drawable.bg_32,
        R.drawable.bg_64,
        R.drawable.bg_128,
        R.drawable.bg_256,
        R.drawable.bg_512,
        R.drawable.bg_1024,
        R.drawable.bg_2048
    )

    fun getBackground(number: Int): Int = backgroundList[number.degreeOfTwo()]

    fun shareApp(activity: MainActivity) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "2048")
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "There will be a set of squares that you need to add to each other if the numbers are the same, then it is added." +
                    "\nBreak records of luck)" +
                    "\n\nLink: https://play.google.com/store/apps/details?id=com.sultandev.2048"
        )
        activity.startActivity(Intent.createChooser(intent, "2048"))
    }

}

fun Int.degreeOfTwo(): Int {
    var value = this
    var deg = 0
    while (value > 1) {
        value /= 2
        deg++
    }
    return deg
}

