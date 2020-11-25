package com.danielcunha.zaz.ui.authentication

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentAuthenticationBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class AuthenticationFragment : BaseFragment<AuthenticationViewModel, FragmentAuthenticationBinding>() {

    override val viewModel: AuthenticationViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_authentication

}