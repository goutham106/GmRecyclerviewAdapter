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
import com.gm.kotlindemo.util.SpannableStringUtils
import com.gm.kotlindemo.util.ToastUtils
import com.gm.kotlindemo.util.Utils

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class PullToRefreshAdapter : BaseQuickAdapter<Status, BaseViewHolder>(R.layout.layout_animation, DataServer.getSampleData(10)) {

    override fun convert(helper: BaseViewHolder, item: Status) {
        when (helper.layoutPosition % 3) {
            0 -> helper.setImageResource(R.id.img, R.mipmap.animation_img1)
            1 -> helper.setImageResource(R.id.img, R.mipmap.animation_img2)
            2 -> helper.setImageResource(R.id.img, R.mipmap.animation_img3)
        }
        helper.setText(R.id.tweetName, "Test Title")
        val msg = "\"This is a test description for testing purpose\""
        (helper.getView<View>(R.id.tweetText) as TextView).setText(SpannableStringUtils.Builder(msg).append("This is a spannable link").setClickSpan(clickableSpan).create())
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
