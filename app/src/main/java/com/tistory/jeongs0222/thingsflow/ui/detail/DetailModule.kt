package com.tistory.jeongs0222.thingsflow.ui.detail

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val DetailModule = module {

    viewModel {
        DetailViewModel()
    }

}