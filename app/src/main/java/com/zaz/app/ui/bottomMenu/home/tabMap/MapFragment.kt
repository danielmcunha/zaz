package com.zaz.app.ui.bottomMenu.home.tabMap

import com.zaz.app.R
import com.zaz.app.databinding.FragmentMapBinding
import com.zaz.app.ui.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment<MapViewModel, FragmentMapBinding>() {

    override val viewModel: MapViewModel by viewModel()
    override fun layoutResId() = R.layout.fragment_map

}