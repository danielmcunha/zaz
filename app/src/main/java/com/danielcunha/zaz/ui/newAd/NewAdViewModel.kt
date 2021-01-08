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
            RegisterAdViewHolder(
                getString(R.string.register_job_opportunity),
                R.drawable.ic_recruitment
            ),
            RegisterAdViewHolder(
                getString(R.string.register_promotion),
                R.drawable.ic_sale
            ),
            RegisterAdViewHolder(
                getString(R.string.register_immobile),
                R.drawable.ic_building
            ),
            RegisterAdViewHolder(
                getString(R.string.register_vehicle),
                R.drawable.ic_car
            ),
            RegisterAdViewHolder(
                getString(R.string.register_food),
                R.drawable.ic_restaurant
            ),
            RegisterAdViewHolder(
                getString(R.string.register_event),
                R.drawable.ic_event
            )
        )
    }

    init {
        adapter.addItems(registerOptions)
    }
}