package com.danielcunha.zaz.ui.bottomMenu.home.tabList

import android.app.Application
import androidx.core.content.ContextCompat
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.BottomMenuFragmentDirections
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.AdPost
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.AdPostAdapter
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.Category
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.CategoryAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class AdListViewModel(app: Application) : BaseViewModel(app) {

    val categoryAdapter = CategoryAdapter().apply {

    }

    val postAdapter = AdPostAdapter().apply {
        onItemClick = {
            navigateToMain.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToAdPostDetail()
        }
    }

    init {
        postAdapter.addItem(
            AdPost(
                "Desenvolvedor de Sites",
                "R$ 1500,00",
                ContextCompat.getDrawable(app, R.drawable.ad_post_sample),
                ContextCompat.getDrawable(app, R.drawable.image_profile_example),
                "Floyd Miles",
                "3 horas atrás"
            )
        )

        categoryAdapter.addItem(
            Category(0, R.drawable.ic_building)
        )

        categoryAdapter.addItem(
            Category(0, R.drawable.ic_car)
        )
    }
}