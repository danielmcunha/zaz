package com.danielcunha.zaz.ui.authentication.login.register

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.danielcunha.zaz.R
import com.danielcunha.zaz.data.remote.requests.CreateUserRequest
import com.danielcunha.zaz.domain.usecases.CreateUserUseCase
import com.danielcunha.zaz.domain.usecases.LoginUseCase
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.util.showError
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
            createUserUseCase.invoke(
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
                },
                finally = {
                    isLoading.value = false
                }
            )
        }
    }

    fun actionRegistered() {
        back.call()
    }
}