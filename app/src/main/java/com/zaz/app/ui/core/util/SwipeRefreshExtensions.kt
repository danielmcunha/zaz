package com.zaz.app.ui.core.util

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

object SwipeRefreshExtensions {

    @JvmStatic
    @BindingAdapter("refreshListener")
    fun SwipeRefreshLayout.refreshListener(listener: SwipeRefreshLayout.OnRefreshListener) {
        this.setOnRefreshListener(listener)
    }

    @JvmStatic
    @BindingAdapter("loading")
    fun SwipeRefreshLayout.loading(loading: Boolean) {
        this.isRefreshing = loading
    }
}