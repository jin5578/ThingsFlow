package com.tistory.jeongs0222.thingsflow.ui.main

import com.tistory.jeongs0222.thingsflow.domain.MainRepository
import com.tistory.jeongs0222.thingsflow.model.IssueList
import com.tistory.jeongs0222.thingsflow.ui.DisposableViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class MainViewModel(
    private val repository: MainRepository
) : DisposableViewModel() {

    init {
        bringIssueList()
    }

    private fun bringIssueList() {
        compositeDisposable add
                repository.bringIssueList("google", "dagger")
                    .subscribeOn(Schedulers.io())
                    .retry(1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result ->
                        onSuccessBringIssueList(result)
                    }, {
                        onErrorException(it)
                    })
    }

    private fun onSuccessBringIssueList(result: List<IssueList>) {
        Timber.e(result.toString())
    }

    private fun onErrorException(it: Throwable) {
        it.printStackTrace()
    }

}