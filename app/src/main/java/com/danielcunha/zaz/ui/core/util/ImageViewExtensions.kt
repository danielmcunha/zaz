package com.danielcunha.zaz.ui.core.util

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

object ImageViewExtensions {

    @JvmStatic
    @BindingAdapter("srcRes")
    fun ImageView.srcRes(@DrawableRes srcRes: Int) {
        setImageDrawable(ContextCompat.getDrawable(context, srcRes))
    }
}