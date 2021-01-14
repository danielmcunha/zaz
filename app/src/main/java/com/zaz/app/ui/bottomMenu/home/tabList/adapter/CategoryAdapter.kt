package com.zaz.app.ui.bottomMenu.home.tabList.adapter

import androidx.annotation.DrawableRes
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter

class CategoryAdapter : RVBaseAdapter<CategoryViewHolder>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_category
}

data class CategoryViewHolder(
    val id: Int,
    @DrawableRes val drawable: Int
)