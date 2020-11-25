package com.danielcunha.zaz.ui.bottomMenu.home.tabSearch

import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentSearchBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment: BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_search

}