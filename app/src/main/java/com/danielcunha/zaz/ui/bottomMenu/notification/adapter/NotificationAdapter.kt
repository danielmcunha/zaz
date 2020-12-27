package com.danielcunha.zaz.ui.bottomMenu.notification.adapter

import android.graphics.drawable.Drawable
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter

class NotificationAdapter: RVBaseAdapter<Notification>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_notification
}

data class Notification(
    val name: String,
    val title: String,
    val profileImage: Drawable?
)