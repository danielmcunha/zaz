package com.danielcunha.zaz.ui.bottomMenu.notification

import android.app.Application
import androidx.core.content.ContextCompat
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.notification.adapter.Notification
import com.danielcunha.zaz.ui.bottomMenu.notification.adapter.NotificationAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class NotificationsViewModel(app: Application) : BaseViewModel(app) {

    val adapter = NotificationAdapter()

    init {
        adapter.addItem(
            Notification(
                "Darrel Steward",
                "Título bem grande - Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                ContextCompat.getDrawable(app, R.drawable.image_profile_example)
            )
        )
    }
}