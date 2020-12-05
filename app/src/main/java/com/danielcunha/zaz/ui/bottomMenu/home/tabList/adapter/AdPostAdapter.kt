package com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter

import android.graphics.drawable.Drawable
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter

class AdPostAdapter : RVBaseAdapter<AdPost>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_ad_post
}

data class AdPost(
    val title: String,
    val price: String,
    val postImage: Drawable?,
    val userImage: Drawable?,
    val userName: String,
    val postTime: String
)