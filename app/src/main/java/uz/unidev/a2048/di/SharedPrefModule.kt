package uz.sultandev.a2048.di

import android.content.Context
import android.content.SharedPreferences
import com.sultandev.a2048.data.pref.SharedPref
import com.sultandev.a2048.data.pref.impl.SharedPrefImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedPrefModule {

    @[Singleton Provides]
    fun provideSharedPreferences(@ApplicationContext ctx: Context): SharedPreferences =
        ctx.getSharedPreferences("app_data", Context.MODE_PRIVATE)

    @[Singleton Provides]
    fun provideSharedPref(sharedPref: SharedPreferences): SharedPref = SharedPrefImpl(sharedPref)

}