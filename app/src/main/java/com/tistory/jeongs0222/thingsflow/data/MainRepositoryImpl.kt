package com.tistory.jeongs0222.thingsflow.data

import com.tistory.jeongs0222.thingsflow.domain.MainRepository
import com.tistory.jeongs0222.thingsflow.model.IssueList
import com.tistory.jeongs0222.thingsflow.service.ApiService
import io.reactivex.Single


class MainRepositoryImpl(
    private val apiService: ApiService
) : MainRepository {

    override fun bringIssueList(
        org: String,
        repo: String
    ): Single<List<IssueList>> = apiService.bringIssueList(org, repo)

}