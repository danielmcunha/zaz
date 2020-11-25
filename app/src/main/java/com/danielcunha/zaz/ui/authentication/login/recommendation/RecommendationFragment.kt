package com.danielcunha.zaz.ui.authentication.login.recommendation

import android.os.Bundle
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentRecommendationBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecommendationFragment : BaseFragment<RecommendationViewModel, FragmentRecommendationBinding>() {

    override val viewModel: RecommendationViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_recommendation

    override fun onAfterCreateView(savedInstanceState: Bundle?) {

    }
}