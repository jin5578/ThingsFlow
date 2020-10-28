package com.tistory.jeongs0222.thingsflow.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.thingsflow.databinding.ItemIssueListBinding
import com.tistory.jeongs0222.thingsflow.ui.main.MainUiModel


class IssueListAdapter(
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<MainUiModel, IssueListViewHolder>(IssueDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueListViewHolder {
        val binding =
            ItemIssueListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return IssueListViewHolder(binding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: IssueListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class IssueListViewHolder(
    private val binding: ItemIssueListBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MainUiModel) {
        binding.item = item

        binding.lifecycleOwner = lifecycleOwner
        binding.executePendingBindings()
    }
}

object IssueDiff : DiffUtil.ItemCallback<MainUiModel>() {
    override fun areItemsTheSame(
        oldItem: MainUiModel,
        newItem: MainUiModel
    ): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: MainUiModel,
        newItem: MainUiModel
    ): Boolean {
        return oldItem == newItem
    }
}