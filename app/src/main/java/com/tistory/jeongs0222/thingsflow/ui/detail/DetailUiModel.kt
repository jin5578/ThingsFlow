package com.tistory.jeongs0222.thingsflow.ui.detail


data class DetailUser(
    val url: String,
    val login: String
)

data class DetailContent(
    val number: Int,
    val title: String,
    val body: String
)