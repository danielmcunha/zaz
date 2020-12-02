package com.danielcunha.zaz.ui.bottomMenu

import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_UNLOCKED
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentBottomMenuBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class BottomMenuFragment : BaseFragment<BottomMenuViewModel, FragmentBottomMenuBinding>() {

    override val viewModel: BottomMenuViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_bottom_menu

    override fun setupFragment() {
        setupDrawer()
        setupBottomMenu()
    }

    private fun setupDrawer() {
        binding.ivDrawer.setOnClickListener {
            binding.drawerLayout.also { drawer ->
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START)
                } else {
                    drawer.openDrawer(GravityCompat.START)
                }
            }
        }
    }

    private fun setupBottomMenu() {
        binding.bottomNav.setupWithNavController(findNavController())
    }
}