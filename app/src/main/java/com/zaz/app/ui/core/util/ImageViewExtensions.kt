package com.zaz.app.ui.core.util

import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

object ImageViewExtensions {

    @JvmStatic
    @BindingAdapter("srcRes")
    fun ImageView.srcRes(@DrawableRes srcRes: Int) {
        setImageDrawable(ContextCompat.getDrawable(context, srcRes))
    }

    @JvmStatic
    @BindingAdapter("drawableStartRes")
    fun TextView.drawableStartRes(@DrawableRes srcRes: Int) {
        setCompoundDrawablesWithIntrinsicBounds(srcRes, 0, 0, 0)
    }

    @JvmStatic
    @BindingAdapter("uri")
    fun ImageView.imageUri(uri: Uri) {
        setImageURI(uri)
    }

    @JvmStatic
    @BindingAdapter("bitmap")
    fun ImageView.bitmap(bitmap: Bitmap?) {
        bitmap?.let {
            setImageBitmap(it)
        }
    }
}