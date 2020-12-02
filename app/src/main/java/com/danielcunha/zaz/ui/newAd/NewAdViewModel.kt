package com.danielcunha.zaz.ui.newAd

import android.app.Application
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.newAd.adapter.RegisterAdAdapter
import com.danielcunha.zaz.ui.newAd.adapter.RegisterAdViewHolder

class NewAdViewModel(app: Application) : BaseViewModel(app) {

    val adapter = RegisterAdAdapter().apply {
        onItemClick = { viewHolder ->
            navigateTo.value =
                NewAdFragmentDirections.actionNewAdFragmentToRegisterNewAdFragment(viewHolder)
        }
    }

    private val registerOptions by lazy {
        arrayListOf(
            RegisterAdViewHolder(
                getString(R.string.register_service),
                R.drawable.ic_handshake
            ),
            RegisterAdViewHolder(
                getString(R.string.register_product),
                R.drawable.ic_premium
            ),
        )
    }

    init {
        adapter.addItems(registerOptions)
    }
}