package com.zaz.app.ui.authentication.login

import com.zaz.app.R
import com.zaz.app.databinding.FragmentLoginBinding
import com.zaz.app.ui.authentication.AuthenticationFragmentDirections
import com.zaz.app.ui.core.base.BaseFragment
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