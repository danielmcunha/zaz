package com.danielcunha.zaz.ui.bottomMenu.home.tabList

import android.app.Application
import androidx.core.content.ContextCompat
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.AdPost
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.AdPostAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class AdListViewModel(app: Application) : BaseViewModel(app) {

    val adapter = AdPostAdapter()

    init {

    }

    fun setup() {
        adapter.addItem(
            AdPost(
                "Desenvolvedor de Sites",
                "R$ 1500,00",
                ContextCompat.getDrawable(app, R.drawable.ad_post_sample),
                ContextCompat.getDrawable(app, R.drawable.image_profile_example),
                "Floyd Miles",
                "3 horas atrás"
            )
        )
    }
}