package com.danielcunha.zaz.ui.bottomMenu.user.follow.adapter

import android.graphics.drawable.Drawable
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter

class UserFollowAdapter : RVBaseAdapter<UserFollow>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_user_follow
}

data class UserFollow(
    val id: Long,
    val name: String,
    val profileImage: Drawable?,
    val following: Boolean
)