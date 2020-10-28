package com.tistory.jeongs0222.thingsflow.data

import com.tistory.jeongs0222.thingsflow.domain.MainRepository
import com.tistory.jeongs0222.thingsflow.model.Issue
import com.tistory.jeongs0222.thingsflow.service.ApiService
import io.reactivex.Single


class MainRepositoryImpl(
    private val apiService: ApiService
) : MainRepository {

    override fun bringIssueList(
        org: String,
        repo: String
    ): Single<List<Issue>> = apiService.bringIssueList(org, repo)

}