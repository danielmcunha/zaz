package com.zaz.app.ui.newAd

import androidx.fragment.app.viewModels
import com.zaz.app.R
import com.zaz.app.databinding.FragmentNewAdBinding
import com.zaz.app.ui.core.base.BaseFragment

class NewAdFragment: BaseFragment<NewAdViewModel, FragmentNewAdBinding>() {

    override val viewModel: NewAdViewModel by viewModels()
    override fun layoutResId(): Int = R.layout.fragment_new_ad

    override fun setupViewModel() {

    }
}