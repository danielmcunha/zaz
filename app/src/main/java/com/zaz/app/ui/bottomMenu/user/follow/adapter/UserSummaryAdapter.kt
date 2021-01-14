package com.zaz.app.ui.bottomMenu.user.follow.adapter

import android.graphics.drawable.Drawable
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter

class UserSummaryAdapter : RVBaseAdapter<UserSummaryViewHolder>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_user_summary
}

data class UserSummaryViewHolder(
    val id: Long,
    val name: String,
    val profileImage: Drawable?,
    val following: Boolean
)