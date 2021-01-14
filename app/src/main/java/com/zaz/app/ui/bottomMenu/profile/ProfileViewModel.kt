package com.zaz.app.ui.bottomMenu.profile

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.models.UserSummary
import com.zaz.app.domain.usecases.GetFollowersUseCase
import com.zaz.app.domain.usecases.GetFollowingUseCase
import com.zaz.app.domain.usecases.GetUserInfoUseCase
import com.zaz.app.ui.bottomMenu.BottomMenuFragmentDirections
import com.zaz.app.ui.core.base.BaseViewModel
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