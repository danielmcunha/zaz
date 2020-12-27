package com.danielcunha.zaz.ui.bottomMenu.home.tabSearch

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentSearchBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class SearchFragment: BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_search

    override fun setupFragment() {
        binding.rvSearchCategories.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}