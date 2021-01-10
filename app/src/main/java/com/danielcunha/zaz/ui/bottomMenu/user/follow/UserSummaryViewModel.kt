package com.danielcunha.zaz.ui.bottomMenu.user.follow

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.danielcunha.zaz.R
import com.danielcunha.zaz.domain.usecases.GetFollowersUseCase
import com.danielcunha.zaz.domain.usecases.GetFollowingUseCase
import com.danielcunha.zaz.ui.bottomMenu.user.follow.adapter.UserSummaryAdapter
import com.danielcunha.zaz.ui.bottomMenu.user.follow.adapter.UserSummaryViewHolder
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class UserSummaryViewModel(app: Application) : BaseViewModel(app) {

    private val getFollowingUseCase: GetFollowingUseCase by inject()
    private val getFollowersUseCase: GetFollowersUseCase by inject()

    val adapter = UserSummaryAdapter()
    var followers = false
    var userId = 0L

//    init {
//        adapter.addItem(
//            UserSummaryViewHolder(
//                1,
//                "Jeff Bezos",
//                getDrawable(R.drawable.jeff_bezos),
//                true
//            )
//        )
//
//        adapter.addItem(
//            UserSummaryViewHolder(
//                2,
//                "Bill Gates",
//                getDrawable(R.drawable.bill_gates),
//                false
//            )
//        )
//    }

    fun load() {
        isLoading.value = true
        val useCase = if (followers) {
            getFollowersUseCase
        } else {
            getFollowingUseCase
        }

        viewModelScope.launch {
            useCase(userId).fold(
                success = { userSummaryList ->
                    adapter.addItems(
                        userSummaryList.map { userSummary ->
                            UserSummaryViewHolder(
                                userSummary.id,
                                userSummary.name,
                                getDrawable(R.drawable.jeff_bezos),
                                true
                            )
                        }
                    )
                },
                failure = {
                    errorMessage.value = it.message
                }
            ).run {
                isLoading.value = false
            }
        }
    }
}