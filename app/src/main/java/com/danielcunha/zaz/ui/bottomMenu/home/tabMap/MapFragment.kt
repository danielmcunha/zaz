package com.danielcunha.zaz.ui.bottomMenu.home.tabMap

import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentMapBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment<MapViewModel, FragmentMapBinding>() {

    override val viewModel: MapViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_map

}