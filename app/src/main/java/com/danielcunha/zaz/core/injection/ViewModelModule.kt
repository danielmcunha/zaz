package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.ui.authentication.AuthenticationViewModel
import com.danielcunha.zaz.ui.authentication.login.LoginViewModel
import com.danielcunha.zaz.ui.authentication.login.recommendation.RecommendationViewModel
import com.danielcunha.zaz.ui.authentication.login.register.RegisterViewModel
import com.danielcunha.zaz.ui.bottomMenu.BottomMenuViewModel
import com.danielcunha.zaz.ui.bottomMenu.home.HomeViewModel
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.AdListViewModel
import com.danielcunha.zaz.ui.newAd.NewAdViewModel
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
}