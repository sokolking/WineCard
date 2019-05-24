package com.pax.winecard.app

import android.app.Application
import com.pax.winecard.di.AppComponent
import com.pax.winecard.di.AppModule
import com.pax.winecard.di.DaggerAppComponent
import com.pax.winecard.di.logistic.DaggerLogisticComponent
import com.pax.winecard.di.logistic.LogisticComponent

class App : Application() {

    companion object {
        lateinit var graph: AppComponent
        lateinit var logis: LogisticComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        logis = DaggerLogisticComponent.builder().appComponent(graph).build()
    }
}
