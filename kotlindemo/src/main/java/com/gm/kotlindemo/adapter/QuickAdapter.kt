package com.gm.kotlindemo.adapter

import com.gm.base.adapter.BaseQuickAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.R
import com.gm.kotlindemo.data.DataServer
import com.gm.kotlindemo.entity.Status

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class QuickAdapter(dataSize: Int) : BaseQuickAdapter<Status, BaseViewHolder>(R.layout.layout_animation, DataServer.getSampleData(dataSize)) {

    override fun convert(helper: BaseViewHolder, item: Status) {
        when (helper.layoutPosition % 3) {
            0 -> helper.setImageResource(R.id.img, R.mipmap.animation_img1)
            1 -> helper.setImageResource(R.id.img, R.mipmap.animation_img2)
            2 -> helper.setImageResource(R.id.img, R.mipmap.animation_img3)
        }
        helper.setText(R.id.tweetName, "Test Title")
        helper.setText(R.id.tweetText, "This is a test description for testing purpose")

    }


}
