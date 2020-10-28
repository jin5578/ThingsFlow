package com.tistory.jeongs0222.thingsflow.data

import com.tistory.jeongs0222.thingsflow.domain.DetailRepository
import com.tistory.jeongs0222.thingsflow.model.IssueDetail
import com.tistory.jeongs0222.thingsflow.service.ApiService
import io.reactivex.Single


class DetailRepositoryImpl(
    private val apiService: ApiService
) : DetailRepository {

    override fun bringIssueDetail(org: String, repo: String, number: Int): Single<IssueDetail> =
        apiService.bringIssueDetail(org, repo, number)

}