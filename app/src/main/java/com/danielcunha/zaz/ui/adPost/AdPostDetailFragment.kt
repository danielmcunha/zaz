package com.danielcunha.zaz.ui.adPost

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentAdPostDetailBinding
import com.danielcunha.zaz.ui.authentication.login.register.RegisterFragmentArgs
import com.danielcunha.zaz.ui.core.base.BaseFragment

class AdPostDetailFragment : BaseFragment<AdPostDetailViewModel, FragmentAdPostDetailBinding>() {

    override val viewModel: AdPostDetailViewModel by viewModels()
    override fun layoutResId(): Int = R.layout.fragment_ad_post_detail
    private val args: AdPostDetailFragmentArgs by navArgs()

    override fun setupViewModel() {
        viewModel.businessId = args.businessId
        viewModel.load()
    }
}