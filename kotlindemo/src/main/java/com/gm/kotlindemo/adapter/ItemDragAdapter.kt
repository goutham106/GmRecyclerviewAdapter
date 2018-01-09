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

import com.gm.base.adapter.BaseItemDraggableAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.R

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class ItemDragAdapter(data: List<String>) : BaseItemDraggableAdapter<String, BaseViewHolder>(R.layout.item_draggable_view, data) {

    override fun convert(helper: BaseViewHolder, item: String) {
        when (helper.layoutPosition % 3) {
            0 -> helper.setImageResource(R.id.iv_head, R.mipmap.head_img0)
            1 -> helper.setImageResource(R.id.iv_head, R.mipmap.head_img1)
            2 -> helper.setImageResource(R.id.iv_head, R.mipmap.head_img2)
        }
        helper.setText(R.id.tv, item)
    }
}
