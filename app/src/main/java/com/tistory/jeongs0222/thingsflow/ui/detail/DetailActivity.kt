package com.tistory.jeongs0222.thingsflow.ui.detail

import android.os.Bundle
import com.tistory.jeongs0222.thingsflow.databinding.ActivityDetailBinding
import com.tistory.jeongs0222.thingsflow.ui.BaseActivity
import com.tistory.jeongs0222.thingsflow.R
import org.koin.androidx.viewmodel.ext.android.viewModel




class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override val layoutResourceId: Int = R.layout.activity_detail

    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.apply {
            viewModel = this@DetailActivity.viewModel
            lifecycleOwner = this@DetailActivity
        }
    }
}