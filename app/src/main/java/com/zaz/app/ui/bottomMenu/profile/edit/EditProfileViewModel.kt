package com.zaz.app.ui.bottomMenu.profile.edit

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.zaz.app.R
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.ui.core.base.BaseViewModel
import com.zaz.app.ui.core.base.singleLiveEvent.SingleLiveEvent
import org.koin.core.inject

class EditProfileViewModel(app: Application) : BaseViewModel(app) {

    private val authUser: AuthUser by inject()

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

    private val firebaseStorage = Firebase.storage.reference

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

    fun uploadProfileImage(uri: Uri) {
        val fileRef = firebaseStorage.child("${authUser.user.email}/profile.jpg")
        val uploadTask = fileRef.putFile(uri)

        uploadTask.addOnFailureListener {

        }.addOnSuccessListener { taskSnapshot ->
            back.call()
        }
    }
}