package com.tistory.jeongs0222.thingsflow

import android.app.Application
import com.tistory.jeongs0222.thingsflow.di.AppModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber


class ThingsFlowApp: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin(this, AppModule)
    }
}