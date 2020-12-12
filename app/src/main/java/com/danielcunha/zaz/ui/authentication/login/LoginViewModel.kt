package com.danielcunha.zaz.ui.authentication.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.danielcunha.zaz.R
import com.danielcunha.zaz.data.remote.requests.LoginRequest
import com.danielcunha.zaz.domain.usecases.LoginUseCase
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.util.showError
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

//        if (!validate()) {
//            return
//        }

        viewModelScope.launch {
            loginUseCase.invoke(
                LoginRequest(
                    "dmaia_c@hotmail.com",
                    "14157buzz"
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