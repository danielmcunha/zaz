package com.danielcunha.zaz.ui.bottomMenu.profile.tabList

import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentProfileAdListBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileAdListFragment: BaseFragment<ProfileAdListViewModel, FragmentProfileAdListBinding>() {

    override val viewModel: ProfileAdListViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_profile_ad_list
}