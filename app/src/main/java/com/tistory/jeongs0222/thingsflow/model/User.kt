package com.tistory.jeongs0222.thingsflow.model

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val login: String
)