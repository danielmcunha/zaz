package com.zaz.app.ui.authentication.login.recommendation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.zaz.app.ui.core.base.BaseViewModel

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