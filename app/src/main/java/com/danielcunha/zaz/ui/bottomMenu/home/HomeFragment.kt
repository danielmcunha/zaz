package com.danielcunha.zaz.ui.bottomMenu.home

import android.os.Bundle
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentHomeBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import com.danielcunha.zaz.ui.bottomMenu.home.adapter.HomeTabsAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_home

    override fun setupFragment() {
        setupTabLayoutAndViewPager()
    }

    private fun setupTabLayoutAndViewPager() {
        binding.vpContent.adapter = HomeTabsAdapter(this)

        TabLayoutMediator(binding.tlTabs, binding.vpContent) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.list)
                1 -> getString(R.string.map)
                2 -> getString(R.string.search)
                else -> ""
            }
        }.attach()
    }
}