package com.gm.kotlindemo

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.kotlindemo.adapter.ItemClickAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.entity.ClickEntity

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class ItemClickActivity : BaseActivity() {

    private var mRecyclerView: RecyclerView? = null
    private var adapter: ItemClickAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("ItemClickActivity Activity")
        setContentView(R.layout.activity_item_click)
        mRecyclerView = findViewById(R.id.list) as RecyclerView
        mRecyclerView?.layoutManager = LinearLayoutManager(this)
        initAdapter()
        adapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            Log.d(TAG, "onItemClick: ")
            Toast.makeText(this@ItemClickActivity, "onItemClick" + position, Toast.LENGTH_SHORT).show()
        }
        adapter?.onItemLongClickListener = BaseQuickAdapter.OnItemLongClickListener { adapter, view, position ->
            Log.d(TAG, "onItemLongClick: ")
            Toast.makeText(this@ItemClickActivity, "onItemLongClick" + position, Toast.LENGTH_SHORT).show()
            true
        }
        adapter?.onItemChildClickListener = BaseQuickAdapter.OnItemChildClickListener { adapter, view, position ->
            Log.d(TAG, "onItemChildClick: ")

            Toast.makeText(this@ItemClickActivity, "onItemChildClick" + position, Toast.LENGTH_SHORT).show()
        }
        adapter?.onItemChildLongClickListener = BaseQuickAdapter.OnItemChildLongClickListener { adapter, view, position ->
            Log.d(TAG, "onItemChildLongClick: ")
            Toast.makeText(this@ItemClickActivity, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show()
            true
        }
        mRecyclerView?.addOnItemTouchListener(object : com.gm.base.adapter.listener.OnItemClickListener() {
            override fun onSimpleItemClick(p0: BaseQuickAdapter<*, *>?, p1: View?, p2: Int) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d(TAG, "onItemChildLongClick: ")


            }

        })

        /**
         * you can also use this way to solve your click Event
         */

///**kotlin comment
// * Sometimes we need to create an object that has a slight modification to a class,
// * Do not explicitly declare a new category for it. Java uses anonymous inner classes to deal with this situation.
// * Kotlin overviews the concept with object expressions and object declarations.
// ** /
///*mRecyclerView?.addOnItemTouchListener(object : OnItemClickListener() {
//*/
///**
// * Callback method to be invoked when an item in this AdapterView has
// * been clicked.
//
// * @param view     The view within the AdapterView that was clicked (this
// * *                 will be a view provided by the adapter)
// * *
// * @param position The position of the view in the adapter.
//*/
///*
//override fun onSimpleItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
//Log.d(SimpleClickListener.TAG, "SimpleOnItemClick: ")
//
//}
//
//*/
///**
// * callback method to be invoked when an chidview in this view has been
// * click and held
//
// * @param view     The view whihin the AbsListView that was clicked
// * *
// * @param position The position of the view int the adapter
// * *
// * @return true if the callback consumed the long click ,false otherwise
//*/
///*
//override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
//Logger.d("onItemChildClick $position be click")
//Toast.makeText(this@ItemClickActivity, "onItemChildClick" + position, Toast.LENGTH_SHORT).show()
//
//}
//
//*/
///**
// * Callback method to be invoked when an item in this view has been clicked and held.
// * @param adapter
// * *
// * @param view
// * *
// * @param position
//*/
///*
//override fun onItemLongClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
//Toast.makeText(this@ItemClickActivity, "onItemLongClick" + position, Toast.LENGTH_SHORT).show()
//}
//
//*/
///**
// * Callback method to be invoked when an itemchild in this view has been clicked and held.
// * @param adapter
// * *
// * @param view
// * *
// * @param position
//*/
///*
//override fun onItemChildLongClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
//Toast.makeText(this@ItemClickActivity, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show()
//}
//})*/


    }
    private fun initAdapter() {
        val data = ArrayList<ClickEntity>()
        data.add(ClickEntity(ClickEntity.CLICK_ITEM_VIEW))
        data.add(ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW))
        data.add(ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW))
        data.add(ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW))
        data.add(ClickEntity(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW))
        adapter = ItemClickAdapter(data)
        adapter?.openLoadAnimation()
        mRecyclerView?.adapter = adapter
    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    companion object {
        private val PAGE_SIZE = 10
        private val TAG = "ItemClickActivity"
    }

}


