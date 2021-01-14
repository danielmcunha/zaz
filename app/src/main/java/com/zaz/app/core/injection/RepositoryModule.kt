package com.zaz.app.core.injection

import com.zaz.app.data.remote.repository.AuthRepositoryImpl
import com.zaz.app.data.remote.repository.BusinessRepositoryImpl
import com.zaz.app.data.remote.repository.UserRepositoryImpl
import com.zaz.app.domain.repository.AuthRepository
import com.zaz.app.domain.repository.BusinessRepository
import com.zaz.app.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<BusinessRepository> { BusinessRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}