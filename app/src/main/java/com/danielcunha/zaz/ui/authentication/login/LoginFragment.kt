package com.danielcunha.zaz.ui.authentication.login

import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentLoginBinding
import com.danielcunha.zaz.ui.authentication.AuthenticationFragmentDirections
import com.danielcunha.zaz.ui.core.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override val viewModel: LoginViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_login

    override fun setupFragment() {

    }

    override fun setupViewModel() {
        viewModel.loginSuccess.observe(this) { success ->
            if (success) {
                mainNavController.navigate(AuthenticationFragmentDirections.actionAuthenticationFragmentToBottomMenuFragment())
            }
        }
    }
}