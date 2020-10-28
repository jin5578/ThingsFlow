package com.tistory.jeongs0222.thingsflow.service

import com.tistory.jeongs0222.thingsflow.model.Issue
import com.tistory.jeongs0222.thingsflow.model.IssueDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("{org}/{repo}/issues")
    fun bringIssueList(
        @Path("org") org: String,
        @Path("repo") repo: String
    ): Single<List<Issue>>

    @GET("{org}/{repo}/issues/{number}")
    fun bringIssueDetail(
        @Path("org") org: String,
        @Path("repo") repo: String,
        @Path("number") number: Int
    ): Single<IssueDetail>

}