package com.tistory.jeongs0222.thingsflow.service

import com.tistory.jeongs0222.thingsflow.model.Issue
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("{org}/{repo}/issues")
    fun bringIssueList(
        @Path("org") org: String,
        @Path("repo") repo: String
    ): Single<List<Issue>>

}