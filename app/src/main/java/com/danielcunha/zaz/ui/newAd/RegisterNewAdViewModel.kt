package com.danielcunha.zaz.ui.newAd

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent
import com.danielcunha.zaz.ui.newAd.adapter.ImageAdded
import com.danielcunha.zaz.ui.newAd.adapter.ImageAddedAdapter

class RegisterNewAdViewModel(app: Application) : BaseViewModel(app) {

    val adTitle = MutableLiveData<String>()
    val currency = MutableLiveData<String>()
    val amount = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val hasImages = MutableLiveData(false)
    val adapter = ImageAddedAdapter().apply {
        isEmpty = {
            hasImages.value = !it
        }
    }

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

    fun addImage(uri: Uri) {
        hasImages.value = true
        adapter.addItem(
            ImageAdded(
                uri
            )
        )
    }

    fun actionPublishAd() {

    }
}