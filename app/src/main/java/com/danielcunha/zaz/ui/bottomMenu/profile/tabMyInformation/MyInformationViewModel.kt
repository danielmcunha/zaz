package com.danielcunha.zaz.ui.bottomMenu.profile.tabMyInformation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class MyInformationViewModel(app: Application) : BaseViewModel(app) {

    val email = MutableLiveData("floyd.miles@gmail.com")
    val phone = MutableLiveData("(51) 99999-9999")
    val social = MutableLiveData("@miles.floyd")
}