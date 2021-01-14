package com.zaz.app.ui.authentication

import androidx.fragment.app.viewModels
import com.zaz.app.R
import com.zaz.app.databinding.FragmentAuthenticationBinding
import com.zaz.app.ui.core.base.BaseFragment

class AuthenticationFragment : BaseFragment<AuthenticationViewModel, FragmentAuthenticationBinding>() {

    override val viewModel: AuthenticationViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_authentication

}