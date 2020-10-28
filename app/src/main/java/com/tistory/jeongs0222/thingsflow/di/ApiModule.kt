package com.tistory.jeongs0222.thingsflow.di

import com.tistory.jeongs0222.thingsflow.BuildConfig
import com.tistory.jeongs0222.thingsflow.di.Constants.Api.BASE_URL
import com.tistory.jeongs0222.thingsflow.service.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val ApiModule = module {

    val TIME_OUT: Long = 30

    single {
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = if (BuildConfig.DEBUG)
                                HttpLoggingInterceptor.Level.BODY
                            else
                                HttpLoggingInterceptor.Level.NONE
                        } as Interceptor
                    )
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)
    }

}