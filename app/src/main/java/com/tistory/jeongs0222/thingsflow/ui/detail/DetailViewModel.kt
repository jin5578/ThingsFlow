package com.tistory.jeongs0222.thingsflow.ui.detail

import com.tistory.jeongs0222.thingsflow.domain.DetailRepository
import com.tistory.jeongs0222.thingsflow.model.IssueDetail
import com.tistory.jeongs0222.thingsflow.ui.DisposableViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class DetailViewModel(
    private val repository: DetailRepository
) : DisposableViewModel() {

    init {
        bringIssueDetail()
    }

    private fun bringIssueDetail() {
        compositeDisposable add
                repository.bringIssueDetail("google", "dagger", 2155)
                    .subscribeOn(Schedulers.io())
                    .retry(1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result ->
                        onSuccessBringIssueDetail(result)
                    }, {
                        onErrorException(it)
                    })
    }

    private fun onSuccessBringIssueDetail(result: IssueDetail) {
        Timber.e(result.toString())
    }

    private fun onErrorException(it: Throwable) {
        it.printStackTrace()
    }


}