package com.pax.winecard.di

import android.content.Context
import com.pax.winecard.data.repository.impl.Repository
import com.pax.winecard.data.repository.preferences.PreferenceHelper
import com.pax.winecard.domain.CommonData
import com.pax.winecard.domain.Session
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    fun providesAppContext() = context

    @Provides
    @Singleton
    fun provideAuth() = Repository()

    @Provides
    @Singleton
    fun providePreferences(): PreferenceHelper = PreferenceHelper()

    @Provides
    @Singleton
    fun provideSession(): Session = Session()

    @Provides
    @Singleton
    fun provideCommonData(): CommonData = CommonData()

}
