package com.zaz.app.ui.bottomMenu.profile

import androidx.fragment.app.viewModels
import com.zaz.app.R
import com.zaz.app.databinding.FragmentProfileBinding
import com.zaz.app.ui.bottomMenu.profile.adapter.ProfileTabsAdapter
import com.zaz.app.ui.core.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {

    override val viewModel: ProfileViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_profile

    override fun setupFragment() {
        setupTabLayoutAndViewPager()
    }

    private fun setupTabLayoutAndViewPager() {
        binding.vpContent.adapter = ProfileTabsAdapter(this)

        TabLayoutMediator(binding.tlTabs, binding.vpContent) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.ads)
                1 -> getString(R.string.my_informations)
                else -> ""
            }
        }.attach()
    }
}