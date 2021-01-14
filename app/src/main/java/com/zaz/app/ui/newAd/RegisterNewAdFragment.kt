package com.zaz.app.ui.newAd

import android.net.Uri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.zaz.app.R
import com.zaz.app.databinding.FragmentRegisterNewAdBinding
import com.zaz.app.ui.core.base.BaseFragment
import com.zaz.app.ui.core.camera.CameraFragment.Companion.CAMERA_ERROR_RESULT
import com.zaz.app.ui.core.camera.CameraFragment.Companion.CAMERA_SUCCESS_RESULT

class RegisterNewAdFragment : BaseFragment<RegisterNewAdViewModel, FragmentRegisterNewAdBinding>() {

    override val viewModel: RegisterNewAdViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_register_new_ad

    private val args: RegisterNewAdFragmentArgs by navArgs()

    override fun setupFragment() {
        binding.viewHolder = args.viewHolder

        observeCameraResult()
    }

    override fun setupViewModel() {
        viewModel.openCamera.observe(this) {
            requestCameraPermissions()
        }
    }

    override fun onCameraPermissionGranted() {
        findNavController().navigate(
            RegisterNewAdFragmentDirections.actionRegisterNewAdFragmentToCameraFragment()
        )
    }

    private fun observeCameraResult() {
        getFragmentResult<String>(CAMERA_ERROR_RESULT)?.observe(viewLifecycleOwner) {
            showErrorMessage(it)
        }

        getFragmentResult<Uri>(CAMERA_SUCCESS_RESULT)?.observe(viewLifecycleOwner) {
            viewModel.addImage(it)
        }
    }
}