package com.tistory.jeongs0222.thingsflow.ui.main


sealed class MainUiModel {

    data class IssueTitle(
        val number: Int,
        val title: String
    ) : MainUiModel()

    data class IssueImage(
        val imageUrl: String,
        val homepageUrl: String
    ) : MainUiModel()

}
