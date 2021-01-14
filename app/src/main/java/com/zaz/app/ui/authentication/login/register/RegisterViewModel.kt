package com.zaz.app.ui.authentication.login.register

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zaz.app.R
import com.zaz.app.data.remote.requests.CreateUserRequest
import com.zaz.app.domain.usecases.CreateUserUseCase
import com.zaz.app.ui.core.base.BaseViewModel
import com.zaz.app.ui.core.util.showError
import kotlinx.coroutines.launch
import org.koin.core.inject

class RegisterViewModel(app: Application) : BaseViewModel(app) {

    private val createUserUseCase: CreateUserUseCase by inject()
    lateinit var sponsorEmail: String

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    val nameError = MutableLiveData<String>()
    val emailError = MutableLiveData<String>()
    val passwordError = MutableLiveData<String>()
    val confirmPasswordError = MutableLiveData<String>()

    val registerSuccess = MutableLiveData<Boolean>()

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
                confirmPassword.value.equals(password.value.orEmpty()).also { isValid ->
                    confirmPasswordError.showError(isValid, getString(R.string.invalid_confirm_password))
                }
            }
        )
    }

    fun actionRegister() {
        isLoading.value = true

        if (!validate()) {
            return
        }

        viewModelScope.launch {
            createUserUseCase(
                CreateUserRequest(
                    email.value.orEmpty(),
                    0,
                    name.value.orEmpty(),
                    sponsorEmail,
                    password.value.orEmpty()
                )
            ).fold(
                success = {
                    registerSuccess.value = true
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
        }
    }

    fun actionRegistered() {
        back.call()
    }
}