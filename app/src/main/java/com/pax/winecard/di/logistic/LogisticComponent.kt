package com.pax.winecard.di.logistic

import com.pax.winecard.di.AppComponent
import com.pax.winecard.data.repository.impl.Repository
import com.pax.winecard.data.repository.preferences.PreferenceHelper
import com.pax.winecard.view.activity.MainActivity
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [(LogisticModule::class)])
@LogisticScope
interface LogisticComponent {
    fun inject(preferenceHelper: PreferenceHelper)
    fun inject(mainActivity: MainActivity)
    fun inject(repository: Repository)
}
