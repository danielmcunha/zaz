package com.zaz.app.ui.bottomMenu

import android.app.Application
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.ui.core.base.BaseViewModel
import org.koin.core.inject

class BottomMenuViewModel(app: Application) : BaseViewModel(app) {

    val authUser: AuthUser by inject()

    fun onNewAdClick() {
        navigateTo.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToNewAdFragment()
    }
}