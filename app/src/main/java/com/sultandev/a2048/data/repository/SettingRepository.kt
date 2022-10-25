package com.sultandev.a2048.data.repository

interface SettingRepository {

    fun getMusicState(): Boolean

    fun setMusicState(state: Boolean)

}