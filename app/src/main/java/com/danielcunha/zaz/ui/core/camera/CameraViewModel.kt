package com.danielcunha.zaz.ui.core.camera

import android.app.Application
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent

class CameraViewModel(app: Application) : BaseViewModel(app) {

    val takePhoto = SingleLiveEvent<Any>()

    fun actionTakePhoto() {
        takePhoto.call()
    }
}