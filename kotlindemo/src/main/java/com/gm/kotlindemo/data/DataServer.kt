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

package com.gm.kotlindemo.data


import com.gm.kotlindemo.entity.MultipleItem
import com.gm.kotlindemo.entity.MySection
import com.gm.kotlindemo.entity.Status
import com.gm.kotlindemo.entity.Video
import java.util.*

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
open class DataServer private constructor(){

    companion object{
        private val HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK = "https://avatars1.githubusercontent.com/u/5320603?v=3&s=460"
        private val GOUTHAM_THE_MAESTRO = "Goutham theMaestro"
        
        fun getSampleData(lenth: Int): List<Status> {
            val list = ArrayList<Status>()
            for (i in 0..lenth - 1) {
                val status = Status()
                status.userName=("Gm" + i)
                status.createdAt=("09/01/" + i)
                status.isRetweet=(i % 2 == 0)
                status.userAvatar=("https://avatars1.githubusercontent.com/u/5320603?v=3&s=460")
                status.text=("GmRecyclerViewBaseAdpater")
                list.add(status)
            }
            return list
        }

        fun addData(list: MutableList<Status>, dataSize: Int): List<Status> {
            for (i in 0..dataSize - 1) {
                val status = Status()
                status.userName=("GM" + i)
                status.createdAt=("09/01/" + i)
                status.isRetweet=(i % 2 == 0)
                status.userAvatar=("https://avatars1.githubusercontent.com/u/5320603?v=3&s=460")
                status.text=("Powerful and flexible RecyclerAdapter https://github.com/goutham106/GmRecyclerViewBaseAdpater")
                list.add(status)
            }

            return list
        }

        fun getSampleData(): List<MySection> {
            val list = ArrayList<MySection>()
            list.add(MySection(true, "Section 1", true))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(true, "Section 2", false))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(true, "Section 3", false))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(true, "Section 4", false))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(true, "Section 5", false))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            list.add(MySection(Video(HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK, GOUTHAM_THE_MAESTRO)))
            return list
        }

        fun getStrData(): List<String> {
            val list = ArrayList<String>()
            for (i in 0..19) {
                var str = HTTPS_AVATARS1_GITHUBUSERCONTENT_COM_LINK
                if (i % 2 == 0) {
                    str = GOUTHAM_THE_MAESTRO
                }
                list.add(str)
            }
            return list
        }

        fun getMultipleItemData(): List<MultipleItem> {
            val list = ArrayList<MultipleItem>()
            for (i in 0..4) {
                list.add(MultipleItem(MultipleItem.IMG, MultipleItem.IMG_SPAN_SIZE))
                list.add(MultipleItem(MultipleItem.TEXT, MultipleItem.TEXT_SPAN_SIZE, GOUTHAM_THE_MAESTRO))
                list.add(MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE))
                list.add(MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE_MIN))
                list.add(MultipleItem(MultipleItem.IMG_TEXT, MultipleItem.IMG_TEXT_SPAN_SIZE_MIN))
            }

            return list
        }

    }



}
