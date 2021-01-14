package com.zaz.app.ui.bottomMenu.profile.tabList

import android.app.Application
import androidx.core.content.ContextCompat
import com.zaz.app.R
import com.zaz.app.ui.bottomMenu.profile.tabList.adapter.ProfileAd
import com.zaz.app.ui.bottomMenu.profile.tabList.adapter.ProfileAdAdapter
import com.zaz.app.ui.core.base.BaseViewModel

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