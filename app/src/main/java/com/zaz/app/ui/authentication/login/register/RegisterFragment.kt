package com.zaz.app.ui.authentication.login.register

import androidx.navigation.fragment.navArgs
import com.zaz.app.R
import com.zaz.app.databinding.FragmentRecommendationBinding
import com.zaz.app.ui.authentication.AuthenticationFragmentDirections
import com.zaz.app.ui.core.base.BaseFragment
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