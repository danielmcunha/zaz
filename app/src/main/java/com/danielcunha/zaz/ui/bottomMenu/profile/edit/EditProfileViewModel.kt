package com.danielcunha.zaz.ui.bottomMenu.profile.edit

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent

class EditProfileViewModel(app: Application) : BaseViewModel(app) {

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val cellphone = MutableLiveData<String>()
    val country = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val radius = MutableLiveData("0 KM")
    val business = MutableLiveData("23")
    val ratings = MutableLiveData("4")
    val followers = MutableLiveData("236")
    val following = MutableLiveData("45")

    val openCamera = SingleLiveEvent<Any>()

    var radiusValue: Float = 0f

    init {
        title.value = getString(R.string.edit_profile)
    }

    fun onRadiusChange(radius: Float) {
        radiusValue = radius
        this.radius.value = getString(R.string.num_km, radius.toInt())
    }

    fun actionTakePhoto() {
        openCamera.call()
    }
}