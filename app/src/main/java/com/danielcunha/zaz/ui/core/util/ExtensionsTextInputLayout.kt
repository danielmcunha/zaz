package com.danielcunha.zaz.ui.core.util

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

object ExtensionsTextInputLayout {

    @JvmStatic
    @BindingAdapter("errorState")
    fun editTextErrorState(editText: TextInputLayout, errorText: String?) {
        if (errorText?.isNotBlank() == true) {
            editText.isErrorEnabled = true
            editText.error = errorText
        } else {
            editText.isErrorEnabled = false
            editText.error = null
        }
    }
}
