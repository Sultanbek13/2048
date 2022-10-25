package com.sultandev.a2048.ui.dialog.setting

import androidx.lifecycle.LiveData

interface SettingViewModel {

    val musicStateLiveData: LiveData<Boolean>

    val backClick: LiveData<Unit>

    fun onBackClick()

    fun getMusicState(): Boolean

    fun setMusicState(state: Boolean)

}