package com.danielcunha.zaz.ui.newAd

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent

class RegisterNewAdViewModel(app: Application) : BaseViewModel(app) {

    val adTitle = MutableLiveData<String>()
    val currency = MutableLiveData<String>()
    val amount = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val openCamera = SingleLiveEvent<Any>()

    init {
        title.value = getString(R.string.new_ad)

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
        openCamera.call()
    }

    fun actionPublishAd() {

    }
}