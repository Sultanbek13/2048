package com.sultandev.a2048.ui.fragment.menu

import androidx.lifecycle.LiveData

interface MenuViewModel {

    val playGameClickLiveData: LiveData<Unit>

    val infoClickLiveData: LiveData<Unit>

    val settingClickLiveData: LiveData<Unit>

    val shareClickLiveData: LiveData<Unit>

    fun onClickPlayGame()

    fun onInfoClick()

    fun onSettingClick()

    fun onShareClick()

}