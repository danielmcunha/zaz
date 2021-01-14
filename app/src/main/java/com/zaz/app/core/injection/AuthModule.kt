package com.zaz.app.core.injection

import com.zaz.app.domain.models.AuthUser
import org.koin.dsl.module

val authModule = module {
    single {
        AuthUser()
    }
}