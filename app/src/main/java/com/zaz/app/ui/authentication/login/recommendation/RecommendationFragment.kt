package com.zaz.app.ui.authentication.login.recommendation

import com.zaz.app.R
import com.zaz.app.databinding.FragmentRecommendationBinding
import com.zaz.app.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecommendationFragment : BaseFragment<RecommendationViewModel, FragmentRecommendationBinding>() {

    override val viewModel: RecommendationViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_recommendation

    override fun setupFragment() {

    }
}