package com.sultandev.a2048.ui.dialog.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sultandev.a2048.data.repository.impl.SettingRepositoryImpl
import com.sultandev.a2048.ui.dialog.setting.SettingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModelImpl @Inject constructor(private val repository: SettingRepositoryImpl) :
    SettingViewModel, ViewModel() {

    override val musicStateLiveData: MutableLiveData<Boolean> = MutableLiveData(repository.getMusicState())

    override val backClick: MutableLiveData<Unit> = MutableLiveData()

    override fun onBackClick() {
        backClick.value = Unit
    }

    override fun getMusicState() = repository.getMusicState()

    override fun setMusicState(state: Boolean) {
        repository.setMusicState(state)
    }
}