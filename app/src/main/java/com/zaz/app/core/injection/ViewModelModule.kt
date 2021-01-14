package com.zaz.app.core.injection

import com.zaz.app.ui.adPost.AdPostDetailViewModel
import com.zaz.app.ui.authentication.AuthenticationViewModel
import com.zaz.app.ui.authentication.login.LoginViewModel
import com.zaz.app.ui.authentication.login.recommendation.RecommendationViewModel
import com.zaz.app.ui.authentication.login.register.RegisterViewModel
import com.zaz.app.ui.bottomMenu.BottomMenuViewModel
import com.zaz.app.ui.bottomMenu.home.HomeViewModel
import com.zaz.app.ui.bottomMenu.home.tabList.AdListViewModel
import com.zaz.app.ui.bottomMenu.profile.ProfileViewModel
import com.zaz.app.ui.bottomMenu.profile.tabList.ProfileAdListViewModel
import com.zaz.app.ui.newAd.NewAdViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {

    viewModel { LoginViewModel(get()) }
    viewModel { RecommendationViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { AuthenticationViewModel(get()) }
    viewModel { BottomMenuViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { AdListViewModel(get()) }
    viewModel { NewAdViewModel(get()) }
    viewModel { AdPostDetailViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { ProfileAdListViewModel(get()) }
}