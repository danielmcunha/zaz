package com.danielcunha.zaz.ui.bottomMenu.home.tabList

import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentAdListBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdListFragment : BaseFragment<AdListViewModel, FragmentAdListBinding>() {

    override val viewModel: AdListViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_ad_list

    override fun setupViewModel() {
        viewModel.load()
    }
}