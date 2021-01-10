package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.domain.models.AuthUser
import com.danielcunha.zaz.domain.repository.AuthRepository
import com.danielcunha.zaz.domain.repository.BusinessRepository
import com.danielcunha.zaz.domain.repository.UserRepository
import com.danielcunha.zaz.domain.usecases.*
import org.koin.dsl.module

val useCaseModule = module {

    single { provideLoginUseCase(get(), get()) }
    single { provideCreateUserUseCase(get(), get()) }
    single { provideGetAllBusinessUseCase(get()) }
    single { provideGetBusinessUseCase(get()) }
    single { provideGetFollowersUseCase(get()) }
    single { provideGetFollowingUseCase(get()) }
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

fun provideGetFollowersUseCase(userRepository: UserRepository): GetFollowersUseCase {
    return GetFollowersUseCase(userRepository)
}

fun provideGetFollowingUseCase(userRepository: UserRepository): GetFollowingUseCase {
    return GetFollowingUseCase(userRepository)
}