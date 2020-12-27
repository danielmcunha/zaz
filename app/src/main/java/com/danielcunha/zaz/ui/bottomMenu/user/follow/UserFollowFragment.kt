package com.danielcunha.zaz.ui.bottomMenu.user.follow

import androidx.fragment.app.viewModels
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentUserFollowBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment

class UserFollowFragment: BaseFragment<UserFollowViewModel, FragmentUserFollowBinding>() {

    override val viewModel: UserFollowViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_user_follow

}