package com.tistory.jeongs0222.thingsflow.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.thingsflow.databinding.ItemIssueImageBinding
import com.tistory.jeongs0222.thingsflow.databinding.ItemIssueTitleBinding
import com.tistory.jeongs0222.thingsflow.ui.main.MainUiModel


class IssueListAdapter(
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<MainUiModel, RecyclerView.ViewHolder>(IssueDiff) {

    companion object {
        private val TITLE_TYPE = 0
        private val IMAGE_TYPE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainUiModel.IssueTitle -> TITLE_TYPE
            is MainUiModel.IssueImage -> IMAGE_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TITLE_TYPE -> {
                val binding = ItemIssueTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                IssueTitleListViewHolder(binding, lifecycleOwner)
            }

            IMAGE_TYPE -> {
                val binding = ItemIssueImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                IssueImageListViewHolder(binding, lifecycleOwner)
            }

            else -> {
                throw IllegalStateException("ViewType instance not found for $viewType")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TITLE_TYPE ->
                (holder as IssueTitleListViewHolder).bind(getItem(position))

            IMAGE_TYPE ->
                (holder as IssueImageListViewHolder).bind(getItem(position))
        }
    }

}

class IssueTitleListViewHolder(
    private val binding: ItemIssueTitleBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MainUiModel) {
        binding.item = item as MainUiModel.IssueTitle

        binding.lifecycleOwner = lifecycleOwner
        binding.executePendingBindings()
    }
}

class IssueImageListViewHolder(
    private val binding: ItemIssueImageBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MainUiModel) {
        binding.item = item as MainUiModel.IssueImage

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