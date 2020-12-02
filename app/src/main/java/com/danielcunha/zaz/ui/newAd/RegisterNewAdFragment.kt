package com.danielcunha.zaz.ui.newAd

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentRegisterNewAdBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class RegisterNewAdFragment : BaseFragment<RegisterNewAdViewModel, FragmentRegisterNewAdBinding>() {

    override val viewModel: RegisterNewAdViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_register_new_ad

    private val args: RegisterNewAdFragmentArgs by navArgs()

    override fun setupFragment() {
        binding.viewHolder = args.viewHolder
    }

    override fun setupViewModel() {

    }
}