package com.gm.kotlindemo

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.gm.kotlindemo.adapter.QuickAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.data.DataServer
import kotlinx.android.synthetic.main.activity_empty_view_use.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class EmptyViewUseActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mQuickAdapter: QuickAdapter
    private lateinit var notDataView: View
    private lateinit var errorView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("EmptyView Use")
        setContentView(R.layout.activity_empty_view_use)
        btn_reset.setOnClickListener(this)
        mRecyclerView = findViewById(R.id.rv_list) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        notDataView = layoutInflater.inflate(R.layout.empty_view, mRecyclerView.parent as ViewGroup, false)
        notDataView.setOnClickListener { onRefresh() }
        errorView = layoutInflater.inflate(R.layout.error_view, mRecyclerView.parent as ViewGroup, false)
        errorView.setOnClickListener { onRefresh() }
        initAdapter()
        onRefresh()
    }

    private fun initAdapter() {
        mQuickAdapter = QuickAdapter(0)
        mRecyclerView.adapter = mQuickAdapter
    }

    override fun onClick(v: View) {
        mError = true
        mNoData = true
        mQuickAdapter.setNewData(null)
        onRefresh()
    }

    private var mError = true
    private var mNoData = true

    private fun onRefresh() {
        mQuickAdapter.setEmptyView(R.layout.loading_view, mRecyclerView.parent as ViewGroup)
        Handler().postDelayed({
            if (mError) {
                mQuickAdapter.emptyView = errorView
                mError = false
            } else {
                if (mNoData) {
                    mQuickAdapter.emptyView = notDataView
                    mNoData = false
                } else {
                    mQuickAdapter.setNewData(DataServer.getSampleData(10))
                }
            }
        }, 1000)
    }
}

