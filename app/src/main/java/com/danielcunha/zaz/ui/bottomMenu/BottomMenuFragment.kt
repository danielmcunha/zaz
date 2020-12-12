package com.danielcunha.zaz.ui.bottomMenu

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentBottomMenuBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class BottomMenuFragment : BaseFragment<BottomMenuViewModel, FragmentBottomMenuBinding>() {

    override val viewModel: BottomMenuViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_bottom_menu

    override fun setupFragment() {
        setupNavController()
        setupDrawer()
        setupBottomMenu()
    }

    private fun setupNavController() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    binding.ivLogo.visibility = VISIBLE
                    binding.tvHeaderTitle.visibility = GONE
                }
                R.id.profileFragment -> {
                    binding.ivLogo.visibility = GONE
                    binding.tvHeaderTitle.visibility = VISIBLE
                    binding.tvHeaderTitle.text = getString(R.string.profile)
                }
            }
        }
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

        binding.navView.getHeaderView(0)
            .findViewById<TextView>(R.id.tv_user_name)
            .text = viewModel.authUser.user.name
    }

    private fun setupBottomMenu() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNav.setupWithNavController(navHostFragment.navController)
    }
}