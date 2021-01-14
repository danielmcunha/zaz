package com.zaz.app.core.injection

import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.repository.AuthRepository
import com.zaz.app.domain.repository.BusinessRepository
import com.zaz.app.domain.repository.UserRepository
import com.zaz.app.domain.usecases.*
import org.koin.dsl.module

val useCaseModule = module {

    single { provideLoginUseCase(get(), get()) }
    single { provideCreateUserUseCase(get(), get()) }
    single { provideGetAllBusinessUseCase(get()) }
    single { provideGetBusinessUseCase(get()) }
    single { provideGetFollowersUseCase(get()) }
    single { provideGetFollowingUseCase(get()) }
    single { provideCreateBusinessUseCase(get()) }
    single { provideGetUseInfoUseCase(get()) }
    single { provideGetCategoriesUseCase(get()) }
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

fun provideCreateBusinessUseCase(businessRepository: BusinessRepository): CreateBusinessUseCase {
    return CreateBusinessUseCase(businessRepository)
}

fun provideGetUseInfoUseCase(userRepository: UserRepository): GetUserInfoUseCase {
    return GetUserInfoUseCase(userRepository)
}

fun provideGetCategoriesUseCase(businessRepository: BusinessRepository): GetCategoriesUseCase {
    return GetCategoriesUseCase(businessRepository)
}