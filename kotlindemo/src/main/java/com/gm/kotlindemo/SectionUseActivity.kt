package com.gm.kotlindemo

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.kotlindemo.adapter.SectionAdapter
import com.gm.kotlindemo.base.BaseActivity
import com.gm.kotlindemo.data.DataServer
import com.gm.kotlindemo.entity.MySection

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class SectionUseActivity : BaseActivity() {
    private var mRecyclerView: RecyclerView? = null
    private var mData: List<MySection>? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section_uer)
        setBackBtn()
        setTitle("Section Use")
        mRecyclerView = findViewById(R.id.rv_list) as RecyclerView
        mRecyclerView!!.layoutManager = GridLayoutManager(this, 2)
        mData = DataServer.getSampleData()
        val sectionAdapter = SectionAdapter(R.layout.item_section_content, R.layout.def_section_head, mData!!)

        sectionAdapter.setOnItemClickListener(BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            val mySection = mData!![position]
            if (mySection.isHeader)
                Toast.makeText(this@SectionUseActivity, mySection.header, Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this@SectionUseActivity, mySection.t.name, Toast.LENGTH_LONG).show()
        })
        sectionAdapter.setOnItemChildClickListener(BaseQuickAdapter.OnItemChildClickListener { adapter, view, position -> Toast.makeText(this@SectionUseActivity, "onItemChildClick" + position, Toast.LENGTH_LONG).show() })
        mRecyclerView!!.adapter = sectionAdapter
    }


}
