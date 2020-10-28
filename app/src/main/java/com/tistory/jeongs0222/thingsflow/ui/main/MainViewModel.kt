package com.tistory.jeongs0222.thingsflow.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.tistory.jeongs0222.thingsflow.domain.MainRepository
import com.tistory.jeongs0222.thingsflow.model.Issue
import com.tistory.jeongs0222.thingsflow.model.OrgRepo
import com.tistory.jeongs0222.thingsflow.ui.DisposableViewModel
import com.tistory.jeongs0222.thingsflow.util.SingleLiveEvent
import com.tistory.jeongs0222.thingsflow.util.requireValue
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


class MainViewModel(
    private val repository: MainRepository
) : DisposableViewModel(), MainEventListener {

    private val _titleClicked = SingleLiveEvent<Any>()
    val titleClicked: LiveData<Any>
        get() = _titleClicked

    private val _imageClicked = SingleLiveEvent<String>()
    val imageClicked: LiveData<String>
        get() = _imageClicked

    val orgRepoValue = MutableLiveData<OrgRepo>().apply { value = OrgRepo("google", "dagger") }

    private val issueList = MediatorLiveData<List<Issue>>()

    private val _mainUiModelList = MediatorLiveData<List<MainUiModel>>()
    val mainUiModelList: LiveData<List<MainUiModel>>
        get() = _mainUiModelList


    init {
        _mainUiModelList.addSource(issueList) {
            _mainUiModelList.value = it.groupByMainUiModelList()
        }

        bringIssueList()
    }


    private fun bringIssueList() {
        compositeDisposable add
                repository.bringIssueList(
                    orgRepoValue.requireValue().org,
                    orgRepoValue.requireValue().repo
                )
                    .subscribeOn(Schedulers.io())
                    .retry(1)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ result ->
                        onSuccessBringIssueList(result)
                    }, {
                        onErrorException(it)
                    })
    }

    private fun onSuccessBringIssueList(result: List<Issue>) {
        issueList.value = result
    }

    private fun onErrorException(it: Throwable) {
        it.printStackTrace()
    }

    private fun List<Issue>.groupByMainUiModelList(): List<MainUiModel> {
        val list = mutableListOf<MainUiModel>()

        forEachIndexed { index, issue ->
            if (index == 4) {
                list.add(
                    MainUiModel.IssueImage(
                        "https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png",
                    "https://thingsflow.com/ko/home")
                )
            } else {
                val title = "#" + issue.number + ":" + " " + issue.title

                list.add(MainUiModel.IssueTitle(title))
            }
        }

        return list
    }

    override fun issueTitleClickEvent() {
        _titleClicked.call()
    }

    override fun issueImageClickEvent(url: String) {
        _imageClicked.value = url
    }

}

interface MainEventListener {
    fun issueTitleClickEvent()

    fun issueImageClickEvent(url: String)
}