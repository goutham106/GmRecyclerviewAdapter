package com.gm.kotlindemo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.kotlindemo.adapter.UpFetchAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.entity.Movie
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import java.util.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class UpFetchUseActivity : BaseActivity() {
    internal lateinit var mRecyclerView: RecyclerView
    internal lateinit var mAdapter: UpFetchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("UpFetch Use")
        setContentView(R.layout.activity_data_binding_use)

        mRecyclerView = findViewById(R.id.rv) as RecyclerView
        mAdapter = UpFetchAdapter()
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mAdapter
        mAdapter.setNewData(genData())
        mAdapter.isUpFetchEnable = true
        /**
         * start fetch when scroll to position 2, default is 1.
         */
        mAdapter.setStartUpFetchPosition(2)
        mAdapter.setUpFetchListener(BaseQuickAdapter.UpFetchListener { startUpFetch() })
    }

    private var count: Int = 0

    private fun startUpFetch() {
        count++
        /**
         * set fetching on when start network request.
         */
        mAdapter.isUpFetching = true
        /**
         * get data from internet.
         */
        async(UI) {
            mAdapter.addData(0, genData())
            /**
             * set fetching off when network request ends.
             */
            /**
             * set fetching off when network request ends.
             */
            mAdapter.isUpFetching = false
            /**
             * set fetch enable false when you don't need anymore.
             */
            /**
             * set fetch enable false when you don't need anymore.
             */
            if (count > 5) {
                mAdapter.isUpFetchEnable = false
            }
        }
//        mRecyclerView.postDelayed({
//
//        }, 300)
    }


    private fun genData(): List<Movie> {
        val list = ArrayList<Movie>()
        val random = Random()
        for (i in 0..9) {
            val name = "Gm"
            val price = random.nextInt(10) + 10
            val len = random.nextInt(80) + 60
            val movie = Movie(name, len, price, "He was one of India's most distinguished Developer")
            list.add(movie)
        }
        return list
    }
}
