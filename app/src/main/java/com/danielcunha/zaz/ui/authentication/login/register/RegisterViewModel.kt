package com.danielcunha.zaz.ui.authentication.login.register

import android.app.Application
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class RegisterViewModel(app: Application) : BaseViewModel(app) {

    fun actionRegister() {

    }

    fun actionRegistered() {
        back.call()
    }
}