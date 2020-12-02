package com.danielcunha.zaz.ui.newAd

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class RegisterNewAdViewModel(app: Application) : BaseViewModel(app) {

    val adTitle = MutableLiveData<String>()
    val currency = MutableLiveData<String>()
    val amount = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    init {
        setupValidMediator(
            Pair(adTitle) {
                it.isNotEmpty()
            },
            Pair(amount) {
                it.isNotEmpty()
            },
            Pair(description) {
                it.isNotEmpty()
            }
        )
    }

    fun actionChooseImages() {

    }

    fun actionPublishAd() {

    }
}