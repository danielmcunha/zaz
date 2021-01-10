package com.danielcunha.zaz.ui.bottomMenu.profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.domain.models.UserSummary
import com.danielcunha.zaz.domain.usecases.GetFollowersUseCase
import com.danielcunha.zaz.domain.usecases.GetFollowingUseCase
import com.danielcunha.zaz.domain.usecases.GetUserInfoUseCase
import com.danielcunha.zaz.ui.bottomMenu.BottomMenuFragmentDirections
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class ProfileViewModel(app: Application) : BaseViewModel(app) {

    val authUser: AuthUser by inject()
    val getFollowersUseCase: GetFollowersUseCase by inject()
    val getFollowingUseCase: GetFollowingUseCase by inject()
    val getUserInfoUseCase: GetUserInfoUseCase by inject()
    var followerList : List<UserSummary>? = null
    var followingList : List<UserSummary>? = null

    val profileDescription =
        MutableLiveData("Jovem programador que trabalha como engenheiro de segurança virtual durante o dia, e como hacker vigilante durante a noite")
    val following = MutableLiveData<String>()
    val followers = MutableLiveData<String>()
    val name = MutableLiveData<String>()

    init {
        name.value = authUser.user.name

        viewModelScope.launch {
            getFollowingUseCase(authUser.user.id).fold(
                success = { followingList ->
                    this@ProfileViewModel.followingList = followingList
                    following.value = followingList.size.toString()
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
        }

        viewModelScope.launch {
            getFollowersUseCase(authUser.user.id).fold(
                success = { followerList ->
                    this@ProfileViewModel.followerList = followerList
                    followers.value = followerList.size.toString()
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
        }
    }

    fun actionSetupProfile() {
        navigateToMain.value = BottomMenuFragmentDirections.actionBottomMenuFragmentToEditProfile()
    }

    fun actionSeeFollowing() {
        if (followingList.isNullOrEmpty()) {
            return
        }

        navigateTo.value =
            ProfileFragmentDirections.actionProfileFragmentToUserFollowFragment(false)
    }

    fun actionSeeFollowers() {
        if (followerList.isNullOrEmpty()) {
            return
        }

        navigateTo.value = ProfileFragmentDirections.actionProfileFragmentToUserFollowFragment(true)
    }
}