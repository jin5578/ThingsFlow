package com.tistory.jeongs0222.thingsflow.ui.main

import android.os.Bundle
import com.tistory.jeongs0222.thingsflow.R
import com.tistory.jeongs0222.thingsflow.databinding.ActivityMainBinding
import com.tistory.jeongs0222.thingsflow.ui.BaseActivity
import com.tistory.jeongs0222.thingsflow.ui.main.adapter.IssueListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int = R.layout.activity_main

    private val viewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.apply {
            viewModel = this@MainActivity.viewModel
            lifecycleOwner = this@MainActivity
        }

        setInitView()
    }

    private fun setInitView() {
        supportActionBar?.title = "AndroidAssignment"

        viewDataBinding.recyclerView.adapter = IssueListAdapter(this, this@MainActivity.viewModel)
    }

}