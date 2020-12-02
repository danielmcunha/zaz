package com.danielcunha.zaz.ui.core.util

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<String>.showError(isValid: Boolean, message: String) {
    if (isValid) {
        this.value = ""
    } else {
        this.value = message
    }
}