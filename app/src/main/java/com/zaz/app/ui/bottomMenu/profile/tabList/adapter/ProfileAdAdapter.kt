package com.zaz.app.ui.bottomMenu.profile.tabList.adapter

import android.graphics.drawable.Drawable
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter

class ProfileAdAdapter : RVBaseAdapter<ProfileAd>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_profile_ad
}

data class ProfileAd(
    val title: String,
    val type: String,
    val adImage: Drawable?,
    val stars: String,
    val shares: String
)