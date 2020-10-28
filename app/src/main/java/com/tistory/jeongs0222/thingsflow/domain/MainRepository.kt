package com.tistory.jeongs0222.thingsflow.domain

import com.tistory.jeongs0222.thingsflow.model.IssueList
import io.reactivex.Single


interface MainRepository {

    fun bringIssueList(
        org: String,
        repo: String
    ): Single<List<IssueList>>

}