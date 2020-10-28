package com.tistory.jeongs0222.thingsflow.ui.detail

import com.tistory.jeongs0222.thingsflow.data.DetailRepositoryImpl
import com.tistory.jeongs0222.thingsflow.domain.DetailRepository
import com.tistory.jeongs0222.thingsflow.model.args.DetailArgs
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val DetailModule = module {

    viewModel { (args: DetailArgs) ->
        DetailViewModel(args, get())
    }

    factory {
        DetailRepositoryImpl(get()) as DetailRepository
    }

}