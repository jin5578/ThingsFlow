package com.tistory.jeongs0222.thingsflow.ui.main.adapter

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.thingsflow.model.OrgRepo
import com.tistory.jeongs0222.thingsflow.ui.main.MainUiModel


@BindingAdapter("issueList")
fun issueList(recyclerView: RecyclerView, list: List<MainUiModel>?) {
    list?.let {
        (recyclerView.adapter as IssueListAdapter).apply {
            submitList(it)
        }
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("introText")
fun introText(textView: TextView, orgRepoValue: OrgRepo) {
    textView.text = orgRepoValue.org + " / " + orgRepoValue.repo
}