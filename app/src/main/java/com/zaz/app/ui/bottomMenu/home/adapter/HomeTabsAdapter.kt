package com.zaz.app.ui.bottomMenu.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zaz.app.ui.bottomMenu.home.tabList.AdListFragment
import com.zaz.app.ui.bottomMenu.home.tabSearch.SearchFragment

class HomeTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AdListFragment()
            1 -> SearchFragment()
            2 -> SearchFragment()
            else -> throw RuntimeException("Illegal tab")
        }
    }
}