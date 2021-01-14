package com.zaz.app.ui.core.camera

import android.app.Application
import com.zaz.app.ui.core.base.BaseViewModel
import com.zaz.app.ui.core.base.singleLiveEvent.SingleLiveEvent

class CameraViewModel(app: Application) : BaseViewModel(app) {

    val takePhoto = SingleLiveEvent<Any>()

    fun actionTakePhoto() {
        takePhoto.call()
    }
}