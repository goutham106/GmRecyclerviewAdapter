/*
 * Copyright (C) 2018. Gowtham Parimelazhagan.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.gm.kotlindemo.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.gm.base.adapter.BaseMultiItemQuickAdapter
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.R
import com.gm.kotlindemo.entity.ClickEntity
import com.gm.kotlindemo.util.Utils
import com.orhanobut.logger.Logger

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class ItemClickAdapter(data: List<ClickEntity>) : BaseMultiItemQuickAdapter<ClickEntity, BaseViewHolder>(data), BaseQuickAdapter.OnItemClickListener, BaseQuickAdapter.OnItemChildClickListener {
    internal lateinit var nestAdapter: NestAdapter

    init {
        addItemType(ClickEntity.CLICK_ITEM_VIEW, R.layout.item_click_view)
        addItemType(ClickEntity.CLICK_ITEM_CHILD_VIEW, R.layout.item_click_childview)
        addItemType(ClickEntity.LONG_CLICK_ITEM_VIEW, R.layout.item_long_click_view)
        addItemType(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW, R.layout.item_long_click_childview)
        addItemType(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW, R.layout.item_nest_click)

    }


    override fun convert(helper: BaseViewHolder, item: ClickEntity) {

        when (helper.itemViewType) {
            ClickEntity.CLICK_ITEM_VIEW -> {
                helper.addOnClickListener(R.id.btn)
            }
            ClickEntity.CLICK_ITEM_CHILD_VIEW -> {
                helper.addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add)
                        .addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add)
            }
            ClickEntity.LONG_CLICK_ITEM_VIEW -> {
                helper.addOnLongClickListener(R.id.btn)
            }
            ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW -> {
                helper.addOnLongClickListener(R.id.iv_num_reduce).addOnLongClickListener(R.id.iv_num_add)
                        .addOnClickListener(R.id.iv_num_reduce).addOnClickListener(R.id.iv_num_add)
            }
            ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW -> {
                helper.setNestView(R.id.item_click) // u can set nestview id
                val recyclerView = helper.getView<RecyclerView>(R.id.nest_list)
                recyclerView.layoutManager = LinearLayoutManager(helper.itemView.context, LinearLayoutManager.VERTICAL, false)
                recyclerView.setHasFixedSize(true)

                nestAdapter = NestAdapter()
                nestAdapter.onItemClickListener = this
                nestAdapter.onItemChildClickListener = this
                recyclerView.adapter = nestAdapter
            }
        }
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        Toast.makeText(Utils.getContext(), "childView click", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        Logger.d("Nested RecycleView item received:  click on the first$position once")
        Toast.makeText(Utils.getContext(), "Nested RecycleView item received:  click on the first$position once", Toast.LENGTH_SHORT).show()
    }
}
