package com.pax.winecard.di

import android.content.Context
import com.pax.winecard.data.repository.impl.Repository
import com.pax.winecard.data.repository.preferences.PreferenceHelper
import com.pax.winecard.domain.CommonData
import com.pax.winecard.domain.Session
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context(): Context
    fun repository(): Repository
    fun preferenceHelper(): PreferenceHelper
    fun session(): Session
    fun commonData(): CommonData
}
