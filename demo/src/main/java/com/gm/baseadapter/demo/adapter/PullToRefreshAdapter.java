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

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.gm.base.adapter.BaseQuickAdapter;
import com.gm.base.adapter.BaseViewHolder;
import com.gm.baseadapter.demo.R;
import com.gm.baseadapter.demo.data.DataServer;
import com.gm.baseadapter.demo.entity.Status;
import com.gm.baseadapter.demo.util.SpannableStringUtils;
import com.gm.baseadapter.demo.util.ToastUtils;
import com.gm.baseadapter.demo.util.Utils;


/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class PullToRefreshAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("Event triggered");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };

    public PullToRefreshAdapter() {
        super(R.layout.layout_animation, DataServer.getSampleData(10));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition() %
                3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName, "Test Title");
        String msg = "\"This is a test description for testing purpose\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("This is a spannable link").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }


}
