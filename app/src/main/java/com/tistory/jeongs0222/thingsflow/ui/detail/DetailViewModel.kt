package com.tistory.jeongs0222.thingsflow.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.thingsflow.domain.DetailRepository
import com.tistory.jeongs0222.thingsflow.model.IssueDetail
import com.tistory.jeongs0222.thingsflow.model.args.DetailArgs
import com.tistory.jeongs0222.thingsflow.ui.DisposableViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class DetailViewModel(
    private val args: DetailArgs,
    private val repository: DetailRepository
) : DisposableViewModel() {

    private val _actionBarText = MutableLiveData<String>().apply { value = "#"+args.number }
    val actionBarText: LiveData<String>
        get() = _actionBarText

    private val issueDetail = MediatorLiveData<IssueDetail>()

    private val _detailUser = MediatorLiveData<DetailUser>()
    val detailUser: LiveData<DetailUser>
        get() = _detailUser

    private val _detailContent = MediatorLiveData<DetailContent>()
    val detailContent: LiveData<DetailContent>
        get() = _detailContent


    init {
        _detailUser.addSource(issueDetail) {
            _detailUser.value = it.toDetailUser()
        }

        _detailContent.addSource(issueDetail) {
            _detailContent.value = it.toDetailContent()
        }

        bringIssueDetail()
    }

    private fun bringIssueDetail() {
        compositeDisposable add
                repository.bringIssueDetail(args.org, args.repo, args.number)
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
        issueDetail.value = result
    }

    private fun onErrorException(it: Throwable) {
        it.printStackTrace()
    }

    private fun IssueDetail.toDetailUser(): DetailUser {
        return DetailUser(user.avatarUrl, user.login)
    }

    private fun IssueDetail.toDetailContent(): DetailContent {
        return DetailContent(number, title, body)
    }

}