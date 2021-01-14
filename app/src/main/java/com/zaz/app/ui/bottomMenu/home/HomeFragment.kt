package com.zaz.app.ui.bottomMenu.home

import com.zaz.app.R
import com.zaz.app.databinding.FragmentHomeBinding
import com.zaz.app.ui.core.base.BaseFragment
import com.zaz.app.ui.bottomMenu.home.adapter.HomeTabsAdapter
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