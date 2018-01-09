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

package com.gm.kotlindemo.entity

import com.gm.base.adapter.entity.MultiItemEntity

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class MultipleItem : MultiItemEntity {
    private var itemType: Int = 0
    var spanSize: Int = 0

    constructor(itemType: Int, spanSize: Int, content: String) {
        this.itemType = itemType
        this.spanSize = spanSize
        this.content = content
    }

    constructor(itemType: Int, spanSize: Int) {
        this.itemType = itemType
        this.spanSize = spanSize
    }

    var content: String? = null

    override fun getItemType(): Int {
        return itemType
    }

    companion object {
        val TEXT = 1
        val IMG = 2
        val IMG_TEXT = 3
        val TEXT_SPAN_SIZE = 3
        val IMG_SPAN_SIZE = 1
        val IMG_TEXT_SPAN_SIZE = 4
        val IMG_TEXT_SPAN_SIZE_MIN = 2
    }
}
