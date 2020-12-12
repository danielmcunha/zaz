package com.danielcunha.zaz.ui.bottomMenu.profile.edit

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentEditProfileBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import com.redmadrobot.inputmask.MaskedTextChangedListener

class EditProfileFragment: BaseFragment<EditProfileViewModel, FragmentEditProfileBinding>() {

    override val viewModel: EditProfileViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_edit_profile

    override fun setupFragment() {
        binding.etCellphone.apply {
            val listener = MaskedTextChangedListener("([00]) [00000]-[0000]", this)
            addTextChangedListener(listener)
            onFocusChangeListener = listener
        }
    }
}