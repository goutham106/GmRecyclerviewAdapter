package com.gm.kotlindemo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.kotlindemo.adapter.DataBindingUseAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.entity.Movie
import com.gm.kotlindemo.util.ToastUtils
import java.util.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class DataBindingUseActivity : BaseActivity() {

    internal lateinit var mRecyclerView: RecyclerView
    internal lateinit var mAdapter: DataBindingUseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("DataBinding Use")
        setContentView(R.layout.activity_data_binding_use)

        mRecyclerView = findViewById(R.id.rv) as RecyclerView
        mAdapter = DataBindingUseAdapter(R.layout.item_movie, genData())
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mAdapter
        mAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position -> ToastUtils.showShortToast("onItemClick") }
        mAdapter.onItemChildLongClickListener = BaseQuickAdapter.OnItemChildLongClickListener { adapter, view, position ->
            ToastUtils.showShortToast("onItemChildLongClick")
            true
        }
        mAdapter.onItemLongClickListener = BaseQuickAdapter.OnItemLongClickListener { adapter, view, position ->
            ToastUtils.showShortToast("onItemLongClick")
            true
        }
    }


    private fun genData(): List<Movie> {
        val list = ArrayList<Movie>()
        val random = Random()
        for (i in 0..9) {
            val name = "Gm"
            val price = random.nextInt(10) + 10
            val len = random.nextInt(80) + 60
            val movie = Movie(name, len, price, "He was one of India's most distinguished developer")
            list.add(movie)
        }
        return list
    }
}
