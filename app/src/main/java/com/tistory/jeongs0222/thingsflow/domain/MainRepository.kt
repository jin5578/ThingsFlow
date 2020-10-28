package com.tistory.jeongs0222.thingsflow.domain

import com.tistory.jeongs0222.thingsflow.model.Issue
import io.reactivex.Single


interface MainRepository {

    fun bringIssueList(
        org: String,
        repo: String
    ): Single<List<Issue>>

}