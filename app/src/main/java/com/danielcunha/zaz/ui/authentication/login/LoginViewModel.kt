package com.danielcunha.zaz.ui.authentication.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class LoginViewModel(app: Application) : BaseViewModel(app) {

    val loginSuccess = MutableLiveData<Boolean>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val liveEmail: LiveData<String> = email
    val livePassword: LiveData<String> = password

    fun actionForget() {

    }

    fun actionLogin() {
//        if (!validate()) {
//            return
//        }
        loginSuccess.value = true
    }

    private fun validate(): Boolean {
        var isValid = true

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.value.orEmpty()).matches()) {
            isValid = false
        }

        if (password.value.isNullOrEmpty()) {
            isValid = false
        }

        return isValid
    }

    fun actionRegister() {
        navigateTo.value = LoginFragmentDirections.actionLoginFragmentToRecommendationFragment()
    }
}