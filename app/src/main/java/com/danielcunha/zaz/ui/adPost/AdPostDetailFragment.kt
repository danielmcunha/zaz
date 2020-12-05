package com.danielcunha.zaz.ui.adPost

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentAdPostDetailBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class AdPostDetailFragment : BaseFragment<AdPostDetailViewModel, FragmentAdPostDetailBinding>() {

    override val viewModel: AdPostDetailViewModel by viewModels()
    override fun layoutResId(): Int = R.layout.fragment_ad_post_detail
}