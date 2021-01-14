package com.zaz.app.ui.newAd

import android.app.Application
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.zaz.app.R
import com.zaz.app.data.remote.requests.CreateBusinessRequest
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.usecases.CreateBusinessUseCase
import com.zaz.app.ui.core.base.BaseViewModel
import com.zaz.app.ui.core.base.singleLiveEvent.SingleLiveEvent
import com.zaz.app.ui.newAd.adapter.ImageAdded
import com.zaz.app.ui.newAd.adapter.ImageAddedAdapter
import kotlinx.coroutines.launch
import org.koin.core.inject

class RegisterNewAdViewModel(app: Application) : BaseViewModel(app) {

    val createBusinessUseCase: CreateBusinessUseCase by inject()
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
    private val authUser: AuthUser by inject()
    private val firebaseStorage = Firebase.storage.reference
    private val imagesUri = ArrayList<Uri>()
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
        imagesUri.add(uri)
    }

    fun actionPublishAd() {
        viewModelScope.launch {
            createBusinessUseCase(
                CreateBusinessRequest(
                    21,
                    authUser.user.id,
                    description.value.orEmpty(),
                    2,
                    -30.033056f,
                    -51.230000f,
                    adTitle.value.orEmpty(),
                    amount.value.orEmpty()
                )
            ).fold(
                success = {
                    uploadImages(it)
                },
                failure = {
                    errorMessage.value = it.message
                }
            ).run {
                isLoading.value = false
            }
        }
    }

    private fun uploadImages(id: Long) {
        imagesUri.forEachIndexed { index, uri ->
            val fileRef = firebaseStorage.child("${id}/${index}.jpg")
            val uploadTask = fileRef.putFile(uri)

            uploadTask.addOnFailureListener {

            }.addOnSuccessListener { taskSnapshot ->
                back.call()
            }
        }
    }
}