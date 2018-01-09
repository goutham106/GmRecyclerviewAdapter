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
class ClickEntity(var Type: Int) : MultiItemEntity {

    override fun getItemType(): Int {
        return Type
    }

    companion object {
        val CLICK_ITEM_VIEW = 1
        val CLICK_ITEM_CHILD_VIEW = 2
        val LONG_CLICK_ITEM_VIEW = 3
        val LONG_CLICK_ITEM_CHILD_VIEW = 4
        val NEST_CLICK_ITEM_CHILD_VIEW = 5
    }
}
