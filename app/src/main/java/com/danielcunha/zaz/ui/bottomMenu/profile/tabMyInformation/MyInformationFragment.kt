package com.danielcunha.zaz.ui.bottomMenu.profile.tabMyInformation

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentMyInformationBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class MyInformationFragment : BaseFragment<MyInformationViewModel, FragmentMyInformationBinding>() {

    override val viewModel: MyInformationViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_my_information
}