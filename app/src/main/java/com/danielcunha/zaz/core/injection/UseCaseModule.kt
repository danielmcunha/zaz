package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.domain.repository.AuthRepository
import com.danielcunha.zaz.domain.repository.BusinessRepository
import com.danielcunha.zaz.domain.usecases.CreateUserUseCase
import com.danielcunha.zaz.domain.usecases.GetAllBusinessUseCase
import com.danielcunha.zaz.domain.usecases.GetBusinessUseCase
import com.danielcunha.zaz.domain.usecases.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { provideLoginUseCase(get(), get()) }
    single { provideCreateUserUseCase(get(), get()) }
    single { provideGetAllBusinessUseCase(get()) }
    single { provideGetBusinessUseCase(get()) }
}

fun provideLoginUseCase(authRepository: AuthRepository, authUser: AuthUser): LoginUseCase {
    return LoginUseCase(authRepository, authUser)
}

fun provideCreateUserUseCase(
    authRepository: AuthRepository,
    authUser: AuthUser
): CreateUserUseCase {
    return CreateUserUseCase(authRepository, authUser)
}

fun provideGetAllBusinessUseCase(businessRepository: BusinessRepository): GetAllBusinessUseCase {
    return GetAllBusinessUseCase(businessRepository)
}

fun provideGetBusinessUseCase(businessRepository: BusinessRepository): GetBusinessUseCase {
    return GetBusinessUseCase(businessRepository)
}