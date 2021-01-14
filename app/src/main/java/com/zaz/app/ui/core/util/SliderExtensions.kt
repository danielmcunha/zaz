package com.zaz.app.ui.core.util

import androidx.databinding.BindingAdapter
import com.google.android.material.slider.Slider

object SliderExtensions {
    @JvmStatic
    @BindingAdapter(value = ["onValueChangeListener"])
    fun Slider.setOnValueChangeListener(listener: OnValueChangeListener) {
        addOnChangeListener { _: Slider?, value: Float, _: Boolean ->
            listener.onValueChange(value)
        }
    }

    interface OnValueChangeListener {
        fun onValueChange(value: Float)
    }
}