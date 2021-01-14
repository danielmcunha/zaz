package com.zaz.app.ui.bottomMenu.profile.edit

import android.net.Uri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.zaz.app.R
import com.zaz.app.databinding.FragmentEditProfileBinding
import com.zaz.app.ui.core.base.BaseFragment
import com.zaz.app.ui.core.camera.CameraFragment
import com.redmadrobot.inputmask.MaskedTextChangedListener

class EditProfileFragment: BaseFragment<EditProfileViewModel, FragmentEditProfileBinding>() {

    override val viewModel: EditProfileViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_edit_profile

    override fun setupFragment() {
        binding.etCellphone.apply {
            val listener = MaskedTextChangedListener("([00]) [00000]-[0000]", this)
            addTextChangedListener(listener)
            onFocusChangeListener = listener

            observeCameraResult()
        }
    }

    override fun setupViewModel() {
        viewModel.openCamera.observe(this) {
            requestCameraPermissions()
        }
    }

    override fun onCameraPermissionGranted() {
        findNavController().navigate(
            EditProfileFragmentDirections.actionEditProfileFragmentToCameraFragment()
        )
    }

    private fun observeCameraResult() {
        getFragmentResult<String>(CameraFragment.CAMERA_ERROR_RESULT)?.observe(this) {
        }

        getFragmentResult<Uri>(CameraFragment.CAMERA_SUCCESS_RESULT)?.observe(this) {
            viewModel.uploadProfileImage(it)
        }
    }
}