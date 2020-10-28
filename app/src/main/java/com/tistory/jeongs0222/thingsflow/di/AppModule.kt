package com.tistory.jeongs0222.thingsflow.di

import com.tistory.jeongs0222.thingsflow.ui.detail.DetailModule
import com.tistory.jeongs0222.thingsflow.ui.main.MainModule


val AppModule = arrayListOf(
    ApiModule,
    MainModule,
    DetailModule
)