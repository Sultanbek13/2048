package uz.sultandev.a2048.ui.fragment.splash.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultandev.a2048.ui.fragment.splash.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor() : SplashViewModel, ViewModel() {

    override val showSplashLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun showSplash() {
        viewModelScope.launch {
            delay(2000)
            showSplashLiveData.value = Unit
        }
    }
}