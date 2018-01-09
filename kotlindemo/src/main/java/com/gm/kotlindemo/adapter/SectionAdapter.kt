package com.gm.kotlindemo.adapter

import com.gm.base.adapter.BaseSectionQuickAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.R
import com.gm.kotlindemo.entity.MySection

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
/**
 * Same as QuickAdapter#QuickAdapter(Context,int) but with
 * some initialization data.

 * @param sectionHeadResId The section head layout id for each item
 * *
 * @param layoutResId      The layout resource id of each item.
 * *
 * @param data             A new list is created out of this one to avoid mutable list
 */
class SectionAdapter constructor(layoutResId: Int, sectionHeadResId: Int, data: List<MySection>) : BaseSectionQuickAdapter<MySection, BaseViewHolder>(layoutResId, sectionHeadResId, data) {

    override fun convertHead(helper: BaseViewHolder, item: MySection) {
        helper.setText(R.id.header, item.header)
        helper.setVisible(R.id.more, item.isMore)
        helper.addOnClickListener(R.id.more)
    }


    override fun convert(helper: BaseViewHolder, item: MySection) {
        val video = item.t
        when (helper.layoutPosition % 2) {
            0 -> helper.setImageResource(R.id.iv, R.mipmap.m_img1)
            1 -> helper.setImageResource(R.id.iv, R.mipmap.m_img2)
        }
        helper.setText(R.id.tv, video.name)
    }
}
