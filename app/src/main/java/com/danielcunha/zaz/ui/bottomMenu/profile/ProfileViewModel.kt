package com.danielcunha.zaz.ui.bottomMenu.profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.ui.bottomMenu.BottomMenuFragmentDirections
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class ProfileViewModel(app: Application) : BaseViewModel(app) {

    val profileDescription = MutableLiveData("Jovem programador que trabalha como engenheiro de segurança virtual durante o dia, e como hacker vigilante durante a noite")
    val following = MutableLiveData("45")
    val followers = MutableLiveData("236")
    val name = MutableLiveData("Floyd Miles")

    fun actionSetupProfile() {
        navigateToMain.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToEditProfile()
    }

    fun actionSeeFollowing() {
        navigateTo.value = ProfileFragmentDirections.actionProfileFragmentToUserFollowFragment()
    }

    fun actionSeeFollowers() {
        navigateTo.value = ProfileFragmentDirections.actionProfileFragmentToUserFollowFragment()
    }
}