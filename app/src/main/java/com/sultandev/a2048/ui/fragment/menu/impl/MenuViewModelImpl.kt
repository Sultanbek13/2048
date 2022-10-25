package com.sultandev.a2048.ui.fragment.menu.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultandev.a2048.ui.fragment.menu.MenuViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModelImpl @Inject constructor(): MenuViewModel, ViewModel() {

    override val playGameClickLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val infoClickLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val settingClickLiveData: MutableLiveData<Unit> = MutableLiveData()
    override val shareClickLiveData: MutableLiveData<Unit> = MutableLiveData()

    override fun onClickPlayGame() {
        viewModelScope.launch {
            delay(500)
            playGameClickLiveData.value = Unit
        }
    }

    override fun onInfoClick() {
        infoClickLiveData.value = Unit
    }

    override fun onSettingClick() {
        settingClickLiveData.value = Unit
    }

    override fun onShareClick() {
        shareClickLiveData.value = Unit
    }
}