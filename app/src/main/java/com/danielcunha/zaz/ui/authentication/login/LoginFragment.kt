package com.danielcunha.zaz.ui.authentication.login

import android.os.Bundle
import androidx.navigation.findNavController
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentLoginBinding
import com.danielcunha.zaz.ui.authentication.AuthenticationFragmentDirections
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override val viewModel: LoginViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_login

    override fun onAfterCreateView(savedInstanceState: Bundle?) {
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.liveEmail.observe(this) { email ->

        }

        viewModel.livePassword.observe(this) { password ->

        }

        viewModel.loginSuccess.observe(this) { success ->
            if (success) {
                mainNavController.navigate(AuthenticationFragmentDirections.actionAuthenticationFragmentToBottomMenuFragment())
            }
        }
    }
}