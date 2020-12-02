package com.danielcunha.zaz.ui.authentication.login.register

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.util.showError

class RegisterViewModel(app: Application) : BaseViewModel(app) {

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    val nameError = MutableLiveData<String>()
    val emailError = MutableLiveData<String>()
    val passwordError = MutableLiveData<String>()
    val confirmPasswordError = MutableLiveData<String>()

    init {
        addValidationRules(
            {
                android.util.Patterns.EMAIL_ADDRESS.matcher(this.email.value.orEmpty()).matches().also { isValid ->
                    emailError.showError(isValid, getString(R.string.invalid_email))
                }
            },
            {
                password.value.orEmpty().isNotEmpty().also { isValid ->
                    passwordError.showError(isValid, getString(R.string.invalid_password))
                }
            },
            {
                android.util.Patterns.EMAIL_ADDRESS.matcher(this.email.value.orEmpty()).matches().also { isValid ->
                    emailError.showError(isValid, getString(R.string.invalid_email))
                }
            },
            {
                confirmPassword.equals(password.value.orEmpty()).also { isValid ->
                    confirmPasswordError.showError(isValid, getString(R.string.invalid_confirm_password))
                }
            }
        )
    }

    fun actionRegister() {
        if (!validate()) {
            return
        }


    }

    fun actionRegistered() {
        back.call()
    }
}