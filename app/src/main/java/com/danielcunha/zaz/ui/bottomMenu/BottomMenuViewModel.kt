package com.danielcunha.zaz.ui.bottomMenu

import android.app.Application
import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import org.koin.core.inject

class BottomMenuViewModel(app: Application) : BaseViewModel(app) {

    val authUser: AuthUser by inject()

    fun onNewAdClick() {
        navigateTo.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToNewAdFragment()
    }
}