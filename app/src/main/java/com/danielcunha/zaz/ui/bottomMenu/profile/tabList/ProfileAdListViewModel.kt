package com.danielcunha.zaz.ui.bottomMenu.profile.tabList

import android.app.Application
import androidx.core.content.ContextCompat
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.profile.tabList.adapter.ProfileAd
import com.danielcunha.zaz.ui.bottomMenu.profile.tabList.adapter.ProfileAdAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class ProfileAdListViewModel(app: Application) : BaseViewModel(app) {

    val adapter = ProfileAdAdapter()

    init {
        adapter.addItem(
            ProfileAd(
                "Desenvolvimento de Sites",
                "Prestação de Serviços",
                ContextCompat.getDrawable(app, R.drawable.ad_post_sample),
                "2",
                "5"
            )
        )
    }
}