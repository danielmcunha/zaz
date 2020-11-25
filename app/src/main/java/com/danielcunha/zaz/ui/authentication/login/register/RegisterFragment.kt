package com.danielcunha.zaz.ui.authentication.login.register

import android.os.Bundle
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentRecommendationBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRecommendationBinding>() {

    override val viewModel: RegisterViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_register

    override fun onAfterCreateView(savedInstanceState: Bundle?) {

    }
}