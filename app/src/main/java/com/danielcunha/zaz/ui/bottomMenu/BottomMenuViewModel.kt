package com.danielcunha.zaz.ui.bottomMenu

import android.app.Application
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent

class BottomMenuViewModel(app: Application) : BaseViewModel(app) {

    fun onNewAdClick() {
        navigateTo.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToNewAdFragment()
    }
}