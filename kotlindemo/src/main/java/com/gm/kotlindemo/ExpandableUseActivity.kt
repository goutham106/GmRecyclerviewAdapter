package com.gm.kotlindemo

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.gm.base.adapter.entity.MultiItemEntity
import com.gm.kotlindemo.adapter.ExpandableItemAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.entity.Level0Item
import com.gm.kotlindemo.entity.Level1Item
import com.gm.kotlindemo.entity.Person
import java.util.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class ExpandableUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var adapter: ExpandableItemAdapter
    private lateinit var list: ArrayList<MultiItemEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBackBtn()
        setTitle("ExpandableItem Activity")
        setContentView(R.layout.activity_expandable_item_use)

        mRecyclerView = findViewById(R.id.rv) as RecyclerView

        list = generateData()
        adapter = ExpandableItemAdapter(list)

        val manager = GridLayoutManager(this, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (adapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON) 1 else manager.spanCount
            }
        }

        mRecyclerView.adapter = adapter
        // important! setLayoutManager should be called after setAdapter
        mRecyclerView.layoutManager = manager
        adapter.expandAll()
    }

    private fun generateData(): ArrayList<MultiItemEntity> {
        val lv0Count = 9
        val lv1Count = 3
        val personCount = 5

        val nameList = arrayOf("Goutham", "Maddy", "Satheesh", "Satheeesh", "Kavin")
        val random = Random()

        val res = ArrayList<MultiItemEntity>()
        for (i in 0..lv0Count - 1) {
            val lv0 = Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i)
            for (j in 0..lv1Count - 1) {
                val lv1 = Level1Item("Level 1 item: " + j, "(no animation)")
                for (k in 0..personCount - 1) {
                    lv1.addSubItem(Person(nameList[k], random.nextInt(40)))
                }
                lv0.addSubItem(lv1)
            }
            res.add(lv0)
        }
        return res
    }
}
