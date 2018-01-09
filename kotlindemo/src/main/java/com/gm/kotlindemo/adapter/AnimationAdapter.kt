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

import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.R
import com.gm.kotlindemo.data.DataServer
import com.gm.kotlindemo.entity.Status
import com.gm.kotlindemo.util.ClickableMovementMethod
import com.gm.kotlindemo.util.SpannableStringUtils
import com.gm.kotlindemo.util.ToastUtils
import com.gm.kotlindemo.util.Utils

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 01/09/18.
 */
class AnimationAdapter : BaseQuickAdapter<Status, BaseViewHolder>(R.layout.layout_animation, DataServer.getSampleData(100)) {

    override fun convert(helper: BaseViewHolder, item: Status) {
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName)
        when (helper.layoutPosition % 3) {
            0 -> helper.setImageResource(R.id.img, R.mipmap.animation_img1)
            1 -> helper.setImageResource(R.id.img, R.mipmap.animation_img2)
            2 -> helper.setImageResource(R.id.img, R.mipmap.animation_img3)
        }
        helper.setText(R.id.tweetName, "Test Title")
        val msg = "\"This is a test description for testing purpose\""
        (helper.getView<View>(R.id.tweetText) as TextView).text = SpannableStringUtils.Builder(msg).append("This is a spannable link").setClickSpan(clickableSpan).create()
        (helper.getView<View>(R.id.tweetText) as TextView).movementMethod = ClickableMovementMethod.getInstance();
        (helper.getView<View>(R.id.tweetText) as TextView).isFocusable = false;
        (helper.getView<View>(R.id.tweetText) as TextView).isClickable = false;
        (helper.getView<View>(R.id.tweetText) as TextView).isLongClickable = false;
        (helper.getView<View>(R.id.tweetText) as TextView).movementMethod = LinkMovementMethod.getInstance()
    }

    internal var clickableSpan: ClickableSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            ToastUtils.showShortToast("Event triggered")
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.color = Utils.getContext().getResources().getColor(R.color.clickspan_color)
            ds.isUnderlineText = true
        }
    }
}

