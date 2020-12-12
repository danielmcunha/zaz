package com.danielcunha.zaz.ui.bottomMenu.profile

import android.app.Application
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.BottomMenuFragmentDirections
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class ProfileViewModel(app: Application) : BaseViewModel(app) {

    fun actionSetupProfile() {
        navigateToMain.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToEditProfile()
    }
}