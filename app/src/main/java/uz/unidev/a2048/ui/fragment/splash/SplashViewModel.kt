package uz.sultandev.a2048.ui.fragment.splash

import androidx.lifecycle.LiveData

interface SplashViewModel {

    val showSplashLiveData: LiveData<Unit>

    fun showSplash()

}