package com.danielcunha.zaz.ui.authentication.login.recommendation

import android.app.Application
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class RecommendationViewModel(app: Application) : BaseViewModel(app) {

    fun actionRegistered() {
        back.call()
    }

    fun actionProceed() {
        navigateTo.value = RecommendationFragmentDirections.actionRecommendationFragmentToRegisterFragment()
    }
}