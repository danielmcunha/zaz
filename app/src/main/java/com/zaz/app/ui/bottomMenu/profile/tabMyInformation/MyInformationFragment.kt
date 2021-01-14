package com.zaz.app.ui.bottomMenu.profile.tabMyInformation

import androidx.fragment.app.viewModels
import com.zaz.app.R
import com.zaz.app.databinding.FragmentMyInformationBinding
import com.zaz.app.ui.core.base.BaseFragment

class MyInformationFragment : BaseFragment<MyInformationViewModel, FragmentMyInformationBinding>() {

    override val viewModel: MyInformationViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_my_information
}