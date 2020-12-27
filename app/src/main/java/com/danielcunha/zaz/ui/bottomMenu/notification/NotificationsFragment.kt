package com.danielcunha.zaz.ui.bottomMenu.notification

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentNotificationsBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class NotificationsFragment : BaseFragment<NotificationsViewModel, FragmentNotificationsBinding>() {

    override val viewModel: NotificationsViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_notifications
}