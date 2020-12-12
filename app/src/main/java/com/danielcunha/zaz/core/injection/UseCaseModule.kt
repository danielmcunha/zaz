package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.domain.repository.AuthRepository
import com.danielcunha.zaz.domain.usecases.CreateUserUseCase
import com.danielcunha.zaz.domain.usecases.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { provideLoginUseCase(get(), get()) }
    single { provideCreateUserUseCase(get(), get()) }
}

fun provideLoginUseCase(authRepository: AuthRepository, authUser: AuthUser): LoginUseCase {
    return LoginUseCase(authRepository, authUser)
}

fun provideCreateUserUseCase(authRepository: AuthRepository, authUser: AuthUser): CreateUserUseCase {
    return CreateUserUseCase(authRepository, authUser)
}