package com.zaz.app.ui.bottomMenu.home.tabSearch

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.zaz.app.R
import com.zaz.app.databinding.FragmentSearchBinding
import com.zaz.app.ui.core.base.BaseFragment

class SearchFragment: BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_search

    override fun setupFragment() {
        binding.rvSearchCategories.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}