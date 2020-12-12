package com.danielcunha.zaz.ui.authentication.login.recommendation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.util.showError

class RecommendationViewModel(app: Application) : BaseViewModel(app) {

    val email = MutableLiveData<String>()

//    init {
//        addValidationRules({
//            android.util.Patterns.EMAIL_ADDRESS.matcher(email.value.orEmpty()).matches()
//                .also { isValid ->
//                    emailError.showError(isValid, getString(R.string.invalid_email))
//                }
//        })
//    }

    fun actionRegistered() {
        back.call()
    }

    fun actionProceed() {
        if (!validate()) {
            return
        }

        navigateTo.value =
            RecommendationFragmentDirections.actionRecommendationFragmentToRegisterFragment(email.value.orEmpty())
    }
}