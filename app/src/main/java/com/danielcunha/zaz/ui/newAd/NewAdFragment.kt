package com.danielcunha.zaz.ui.newAd

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentNewAdBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class NewAdFragment: BaseFragment<NewAdViewModel, FragmentNewAdBinding>() {

    override val viewModel: NewAdViewModel by viewModels()
    override fun layoutResId(): Int = R.layout.fragment_new_ad

    override fun setupViewModel() {

    }
}