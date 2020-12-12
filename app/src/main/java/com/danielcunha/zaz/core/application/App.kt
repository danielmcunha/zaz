package com.danielcunha.zaz.core.application

import android.app.Application
import com.danielcunha.zaz.core.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startDependencyInjection()
    }

    private fun startDependencyInjection() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    viewModelModule,
                    retrofitModule,
                    repositoryModule,
                    useCaseModule,
                    authModule
                )
            )
        }
    }
}
