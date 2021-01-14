package com.zaz.app.ui.adPost

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.zaz.app.R
import com.zaz.app.domain.usecases.GetBusinessUseCase
import com.zaz.app.ui.adPost.adapter.AdPostRatingAdapter
import com.zaz.app.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class AdPostDetailViewModel(app: Application) : BaseViewModel(app) {

    private val getBusinessUseCase: GetBusinessUseCase by inject()
    var businessId: Long? = null

    val ratingAdapter = AdPostRatingAdapter()
    val adType = MutableLiveData<String>()
    val adDate = MutableLiveData<String>()
    val imageBitmap = MutableLiveData<Bitmap>()
    val adPrice = MutableLiveData<String>()
    val adDescription = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val adRatingStars = MutableLiveData<String>()
    private val firebaseStorage = Firebase.storage.reference

    fun load() {
        val businessId = businessId ?: return

        viewModelScope.launch {
            getBusinessUseCase(businessId).fold(
                success = {
                    title.value = it.title
                    adType.value = it.categoryName
                    adDate.value = it.date
                    adPrice.value = it.value
                    adDescription.value = it.description
                    userName.value = it.name

                    val imageRef = firebaseStorage.child("${it.id}/0.jpg")
                    imageRef.getBytes(10000 * 10000).addOnSuccessListener { imageBytes ->
                        imageBitmap.value = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                    }.addOnFailureListener {

                    }
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
        }
    }

    fun actionShare() {

    }

    fun actionRate() {
        navigateTo.value =
            AdPostDetailFragmentDirections.actionAdPostDetailToNewRating(title.value.orEmpty())
    }
}