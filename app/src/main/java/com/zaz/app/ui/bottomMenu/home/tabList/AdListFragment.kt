package com.zaz.app.ui.bottomMenu.home.tabList

import com.zaz.app.R
import com.zaz.app.databinding.FragmentAdListBinding
import com.zaz.app.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AdListFragment : BaseFragment<AdListViewModel, FragmentAdListBinding>() {

    override val viewModel: AdListViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_ad_list

    override fun setupViewModel() {
        viewModel.load()
    }
}