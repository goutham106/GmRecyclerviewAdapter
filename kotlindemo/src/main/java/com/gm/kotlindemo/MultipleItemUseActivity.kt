package com.gm.kotlindemo

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.gm.kotlindemo.adapter.MultipleItemQuickAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.data.DataServer

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class MultipleItemUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_item_use)
        setTitle("MultipleItem Use")
        setBackBtn()
        mRecyclerView = findViewById(R.id.rv_list) as RecyclerView
        val data = DataServer.getMultipleItemData()
        val multipleItemAdapter = MultipleItemQuickAdapter(this, data)
        val manager = GridLayoutManager(this, 4)
        mRecyclerView.layoutManager = manager
        multipleItemAdapter.setSpanSizeLookup({ _, position -> data[position].spanSize })
        mRecyclerView.adapter = multipleItemAdapter
    }


}
