package com.zaz.app.ui.bottomMenu.profile.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zaz.app.ui.bottomMenu.profile.tabList.ProfileAdListFragment
import com.zaz.app.ui.bottomMenu.profile.tabMyInformation.MyInformationFragment
import java.lang.RuntimeException

class ProfileTabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProfileAdListFragment()
            1 -> MyInformationFragment()
            else -> throw RuntimeException("Illegal tab")
        }
    }
}