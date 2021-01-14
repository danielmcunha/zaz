package com.zaz.app.ui.bottomMenu.notification.adapter

import android.graphics.drawable.Drawable
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter

class NotificationAdapter: RVBaseAdapter<Notification>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_notification
}

data class Notification(
    val name: String,
    val title: String,
    val profileImage: Drawable?
)