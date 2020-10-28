package com.tistory.jeongs0222.thingsflow.ui.main

import com.tistory.jeongs0222.thingsflow.data.MainRepositoryImpl
import com.tistory.jeongs0222.thingsflow.domain.MainRepository
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val MainModule = module {

    viewModel {
        MainViewModel(get())
    }

    factory {
        MainRepositoryImpl(get()) as MainRepository
    }

}