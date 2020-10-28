package com.tistory.jeongs0222.thingsflow.domain

import com.tistory.jeongs0222.thingsflow.model.IssueDetail
import io.reactivex.Single


interface DetailRepository {

    fun bringIssueDetail(
        org: String,
        repo: String,
        number: Int
    ): Single<IssueDetail>

}