package com.danielcunha.zaz.ui.bottomMenu.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.AdListFragment

class HomeTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return AdListFragment()
    }
}