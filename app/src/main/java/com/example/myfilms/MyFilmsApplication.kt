package com.example.myfilms

import android.app.Application
import android.content.Context
import com.example.myfilms.di.appModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MyFilmsApplication : Application() {
    init {
        instance = this
    }

    companion object {
        var instance: MyFilmsApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        //Initialize Timber
        Timber.plant(Timber.DebugTree())

        //Initialize Stetho for debugging
        Stetho.initializeWithDefaults(this)

        // Start Koin for dependency injection
        startKoin{
            androidContext(this@MyFilmsApplication)
            modules(
                appModule)
        }
    }
}
