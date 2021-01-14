package com.zaz.app.ui.authentication.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zaz.app.R
import com.zaz.app.data.remote.requests.LoginRequest
import com.zaz.app.domain.usecases.LoginUseCase
import com.zaz.app.ui.core.base.BaseViewModel
import com.zaz.app.ui.core.util.showError
import kotlinx.coroutines.launch
import org.koin.core.inject

class LoginViewModel(app: Application) : BaseViewModel(app) {

    private val loginUseCase: LoginUseCase by inject()

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
        isLoading.value = true

        if (!validate()) {
            isLoading.value = false
            return
        }

        viewModelScope.launch {
            loginUseCase(
                LoginRequest(
                    email.value.orEmpty(),
                    password.value.orEmpty()
                )
            ).fold(
                success = {
                    loginSuccess.value = true
                },
                failure = {
                    errorMessage.value = it.message
                }
            ).run {
                isLoading.value = false
            }
        }
    }

    fun actionRegister() {
        navigateTo.value =
            LoginFragmentDirections.actionLoginFragmentToRecommendationFragment()
    }
}