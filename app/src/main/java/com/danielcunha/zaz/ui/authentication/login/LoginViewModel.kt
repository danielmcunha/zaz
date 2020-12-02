package com.danielcunha.zaz.ui.authentication.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.util.showError

class LoginViewModel(app: Application) : BaseViewModel(app) {

    val loginSuccess = MutableLiveData<Boolean>()

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val emailError = MutableLiveData<String>()
    val passwordError = MutableLiveData<String>()

    init {
        addValidationRules(
            {
                android.util.Patterns.EMAIL_ADDRESS.matcher(email.value.orEmpty()).matches()
                    .also { isValid ->
                        emailError.showError(isValid, getString(R.string.invalid_email))
                    }
            },
            {
                password.value.orEmpty().isNotEmpty().also { isValid ->
                    passwordError.showError(isValid, getString(R.string.invalid_password))
                }
            }
        )
    }

    fun actionForget() {

    }

    fun actionLogin() {
        if (!validate()) {
//            return
        }

        loginSuccess.value = true
    }

    fun actionRegister() {
        navigateTo.value = LoginFragmentDirections.actionLoginFragmentToRecommendationFragment()
    }
}