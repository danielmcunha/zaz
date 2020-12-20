package com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter

class CategoryAdapter : RVBaseAdapter<Category>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_category
}

data class Category(
    val id: Int,
    @DrawableRes val drawable: Int
)