/*
 * Copyright (C) 2017. Gowtham Parimelazhagan.
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

package com.gm.baseadapter.demo.adapter;


import com.gm.base.adapter.BaseSectionQuickAdapter;
import com.gm.base.adapter.BaseViewHolder;
import com.gm.baseadapter.demo.R;
import com.gm.baseadapter.demo.entity.MySection;
import com.gm.baseadapter.demo.entity.Video;

import java.util.List;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param layoutResId      The layout resource id of each item.
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }


    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        Video video = (Video) item.t;
        switch (helper.getLayoutPosition() %
                2) {
            case 0:
                helper.setImageResource(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setImageResource(R.id.iv, R.mipmap.m_img2);
                break;

        }
        helper.setText(R.id.tv, video.getName());
    }
}
