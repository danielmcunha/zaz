package com.zaz.app.ui.bottomMenu.profile.tabMyInformation

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.usecases.GetUserInfoUseCase
import com.zaz.app.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class MyInformationViewModel(app: Application) : BaseViewModel(app) {

    val authUser: AuthUser by inject()
    val getUserInfoUseCase: GetUserInfoUseCase by inject()

    val email = MutableLiveData("floyd.miles@gmail.com")
    val phone = MutableLiveData("(51) 99999-9999")
    val social = MutableLiveData("@miles.floyd")
    val profileRating = MutableLiveData(3.5f)

    init {
        viewModelScope.launch {
            getUserInfoUseCase(authUser.user.id).fold(
                success = {
                    email.value = it.email
//                    phone.value = it.phone
//                    social.value = it.
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
        }
    }
}