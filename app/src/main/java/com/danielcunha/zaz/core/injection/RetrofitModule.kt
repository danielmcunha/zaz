package com.danielcunha.zaz.core.injection

import com.danielcunha.zaz.BuildConfig
import com.danielcunha.zaz.data.remote.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(15, TimeUnit.SECONDS)
                    .build()
            )
            .build()
            .create(ApiService::class.java)
    }
}