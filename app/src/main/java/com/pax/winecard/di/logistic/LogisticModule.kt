package com.pax.winecard.di.logistic

import com.pax.winecard.view.activity.IMainPresenter
import com.pax.winecard.view.activity.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class LogisticModule {

    @Provides
    @LogisticScope
    fun provideCabinetPresenter(): IMainPresenter.Presenter {
        return MainPresenter()
    }
}
