package com.zaz.app.ui.adPost

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.zaz.app.R
import com.zaz.app.databinding.FragmentAdPostDetailBinding
import com.zaz.app.ui.core.base.BaseFragment

class AdPostDetailFragment : BaseFragment<AdPostDetailViewModel, FragmentAdPostDetailBinding>() {

    override val viewModel: AdPostDetailViewModel by viewModels()
    override fun layoutResId(): Int = R.layout.fragment_ad_post_detail
    private val args: AdPostDetailFragmentArgs by navArgs()

    override fun setupViewModel() {
        viewModel.businessId = args.businessId
        viewModel.load()
    }
}