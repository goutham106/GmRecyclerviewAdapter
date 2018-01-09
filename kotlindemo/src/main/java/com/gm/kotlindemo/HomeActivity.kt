package com.gm.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.kotlindemo.adapter.HomeAdapter
import com.gm.kotlindemo.entity.HomeItem
import java.util.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class HomeActivity : AppCompatActivity() {
    private lateinit var mDataList: ArrayList<HomeItem>
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
        initData()
        initAdapter()
    }

    private fun initView() {
        mRecyclerView = findViewById(R.id.rv_list) as RecyclerView
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun initAdapter() {
        val homeAdapter = HomeAdapter(R.layout.home_item_view, mDataList)
        homeAdapter.openLoadAnimation()
        val top = layoutInflater.inflate(R.layout.top_view, mRecyclerView.parent as ViewGroup, false)
        homeAdapter.addHeaderView(top)
        homeAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val intent = Intent(this@HomeActivity, ACTIVITY[position])
            startActivity(intent)
        }
        homeAdapter.notifyDataSetChanged()
        mRecyclerView.adapter = homeAdapter
    }

    private fun initData() {
        mDataList = ArrayList<HomeItem>()
        for (i in TITLE.indices) {
            val item = HomeItem()
            item.title = (TITLE[i])
            item.activity = (ACTIVITY[i])
            item.imageResource = (IMG[i])
            mDataList.add(item)
        }
    }

    /*
    * Associated objects Members of this companion object can be called using only the class name as a qualifier:
    *
    * */
    companion object {
        private val ACTIVITY = arrayOf<Class<*>>(AnimationUseActivity::class.java, MultipleItemUseActivity::class.java, HeaderAndFooterUseActivity::class.java, PullToRefreshUseActivity::class.java, SectionUseActivity::class.java, EmptyViewUseActivity::class.java, ItemDragAndSwipeUseActivity::class.java, ItemClickActivity::class.java, ExpandableUseActivity::class.java, DataBindingUseActivity::class.java, UpFetchUseActivity::class.java)
        private val TITLE = arrayOf("Animation", "MultipleItem", "Header/Footer", "PullToRefresh", "Section", "EmptyView", "DragAndSwipe", "ItemClick", "ExpandableItem", "DataBinding", "UpFetchData")
        private val IMG = intArrayOf(R.mipmap.gv_animation, R.mipmap.gv_multipleltem, R.mipmap.gv_header_and_footer, R.mipmap.gv_pulltorefresh, R.mipmap.gv_section, R.mipmap.gv_empty, R.mipmap.gv_drag_and_swipe, R.mipmap.gv_item_click, R.mipmap.gv_expandable, R.mipmap.gv_databinding, R.drawable.gv_up_fetch)
    }

}

