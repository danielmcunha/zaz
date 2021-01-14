package com.zaz.app.core.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.zaz.app.core.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startDependencyInjection()
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)

        Firebase.auth.signInAnonymously()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                } else {

                }
            }
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
