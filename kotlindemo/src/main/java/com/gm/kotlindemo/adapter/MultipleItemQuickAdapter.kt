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

import android.content.Context
import com.gm.base.adapter.BaseMultiItemQuickAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.R
import com.gm.kotlindemo.entity.MultipleItem

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class MultipleItemQuickAdapter(context: Context, data: List<MultipleItem>) : BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(data) {

    init {
        addItemType(MultipleItem.TEXT, R.layout.item_text_view)
        addItemType(MultipleItem.IMG, R.layout.item_image_view)
        addItemType(MultipleItem.IMG_TEXT, R.layout.item_img_text_view)
    }

    override fun convert(helper: BaseViewHolder, item: MultipleItem) {
        when (helper.itemViewType) {
            MultipleItem.TEXT -> helper.setText(R.id.tv, item.content)
            MultipleItem.IMG_TEXT -> when (helper.layoutPosition % 2) {
                0 -> helper.setImageResource(R.id.iv, R.mipmap.animation_img1)
                1 -> helper.setImageResource(R.id.iv, R.mipmap.animation_img2)
            }
        }
    }

}
