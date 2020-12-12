package com.danielcunha.zaz.ui.bottomMenu.profile

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentProfileBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

    override val viewModel: ProfileViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_profile
}