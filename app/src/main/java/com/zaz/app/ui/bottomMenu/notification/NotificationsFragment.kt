package com.zaz.app.ui.bottomMenu.notification

import androidx.fragment.app.viewModels
import com.zaz.app.R
import com.zaz.app.databinding.FragmentNotificationsBinding
import com.zaz.app.ui.core.base.BaseFragment

class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>() {

    override val viewModel: NotificationsViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_notifications
}