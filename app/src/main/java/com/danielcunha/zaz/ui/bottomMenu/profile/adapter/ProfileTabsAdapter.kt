package com.danielcunha.zaz.ui.bottomMenu.profile.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danielcunha.zaz.ui.bottomMenu.profile.tabList.ProfileAdListFragment
import com.danielcunha.zaz.ui.bottomMenu.profile.tabMyInformation.MyInformationFragment

class ProfileTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileAdListFragment()
            1 -> MyInformationFragment()
            else -> throw Exception("Illegal tab")
        }
    }
}