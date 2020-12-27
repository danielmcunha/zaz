package com.danielcunha.zaz.ui.bottomMenu.user.follow

import android.app.Application
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.user.follow.adapter.UserFollow
import com.danielcunha.zaz.ui.bottomMenu.user.follow.adapter.UserFollowAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class UserFollowViewModel(app: Application) : BaseViewModel(app) {

    val adapter = UserFollowAdapter()

    init {
        adapter.addItem(
            UserFollow(
                1,
                "Jeff Bezos",
                getDrawable(R.drawable.jeff_bezos),
                true
            )
        )

        adapter.addItem(
            UserFollow(
                2,
                "Bill Gates",
                getDrawable(R.drawable.bill_gates),
                false
            )
        )
    }
}