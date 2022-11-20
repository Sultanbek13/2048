package uz.sultandev.a2048.data.repository.impl

import uz.sultandev.a2048.data.pref.SharedPref
import uz.sultandev.a2048.data.repository.SettingRepository
import javax.inject.Inject

class SettingRepositoryImpl @Inject constructor(private val sharedPref: SharedPref) :
    SettingRepository {

    override fun getMusicState(): Boolean = sharedPref.getMusic()

    override fun setMusicState(state: Boolean) {
        sharedPref.setMusic(state)
    }
}