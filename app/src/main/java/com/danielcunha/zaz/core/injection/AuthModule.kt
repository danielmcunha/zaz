package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.domain.models.AuthUser
import org.koin.dsl.module

val authModule = module {
    single {
        AuthUser()
    }
}