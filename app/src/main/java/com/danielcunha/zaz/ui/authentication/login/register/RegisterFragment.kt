package com.danielcunha.zaz.ui.authentication.login.register

import androidx.navigation.fragment.navArgs
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentRecommendationBinding
import com.danielcunha.zaz.ui.authentication.AuthenticationFragmentDirections
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRecommendationBinding>() {

    override val viewModel: RegisterViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_register

    private val args: RegisterFragmentArgs by navArgs()

    override fun setupFragment() {

    }

    override fun setupViewModel() {
        viewModel.sponsorEmail = args.sponsorEmail

        viewModel.registerSuccess.observe(this) { success ->
            if (success) {
                mainNavController.navigate(AuthenticationFragmentDirections.actionAuthenticationFragmentToBottomMenuFragment())
            }
        }
    }
}