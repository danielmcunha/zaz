package com.danielcunha.zaz.ui.adPost.rating

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class NewRatingViewModel(app: Application) : BaseViewModel(app) {

    val rating = MutableLiveData<String>()

    fun setup(title: String) {
        this.title.value = title
    }

    fun actionRate() {

    }
}