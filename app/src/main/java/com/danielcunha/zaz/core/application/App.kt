package com.danielcunha.zaz.core.application

import android.app.Application
import com.danielcunha.zaz.core.injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startDependencyInjection()
    }

    private fun startDependencyInjection() {
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@App)
            // declare modules
            modules(listOf(viewModelModule))
        }
    }
}
