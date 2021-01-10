package com.danielcunha.zaz.ui.bottomMenu.user.follow

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentUserSummaryBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class UserSummaryFragment: BaseFragment<UserSummaryViewModel, FragmentUserSummaryBinding>() {

    override val viewModel: UserSummaryViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_user_summary

    private val args : UserSummaryFragmentArgs by navArgs()

    override fun setupViewModel() {
        viewModel.followers = args.followers
    }
}