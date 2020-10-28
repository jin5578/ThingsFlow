package com.tistory.jeongs0222.thingsflow.model


data class IssueDetail(
    val number: Int,
    val title: String,
    val body: String,
    val user: User
)