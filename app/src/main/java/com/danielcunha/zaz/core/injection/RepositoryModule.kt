package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.data.remote.repository.AuthRepositoryImpl
import com.danielcunha.zaz.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<AuthRepository> { AuthRepositoryImpl(get()) }
}