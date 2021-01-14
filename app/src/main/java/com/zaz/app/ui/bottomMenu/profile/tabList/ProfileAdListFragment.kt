package com.zaz.app.ui.bottomMenu.profile.tabList

import com.zaz.app.R
import com.zaz.app.databinding.FragmentProfileAdListBinding
import com.zaz.app.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileAdListFragment: BaseFragment<ProfileAdListViewModel, FragmentProfileAdListBinding>() {

    override val viewModel: ProfileAdListViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_profile_ad_list
}