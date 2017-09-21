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

package com.gm.baseadapter.demo.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable dividerDrawable;
    private int orientation = LinearLayoutManager.VERTICAL;

    public GridItemDecoration(Drawable divider) {
        dividerDrawable = divider;
    }

    public GridItemDecoration(Context context, int resId) {
        dividerDrawable = context.getResources().getDrawable(resId);
    }

    public GridItemDecoration(Context context, int resId, int orientation) {
        dividerDrawable = context.getResources().getDrawable(resId);
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (dividerDrawable == null) {
            return;
        }

        if (parent.getChildLayoutPosition(view) < 1) {
            return;
        }

        if (orientation == LinearLayoutManager.VERTICAL) {
            outRect.top = dividerDrawable.getIntrinsicHeight();
        } else if (orientation == LinearLayoutManager.HORIZONTAL) {
            outRect.left = dividerDrawable.getIntrinsicWidth();
        }
    }

    /**
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (dividerDrawable == null) {
            return;
        }

        int childCount = parent.getChildCount();
        int rightV = parent.getWidth();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int leftV = parent.getPaddingLeft() + child.getPaddingLeft();
            int bottomV = child.getTop() - params.topMargin;
            int topV = bottomV - dividerDrawable.getIntrinsicHeight();

            int topH = child.getTop() + params.topMargin;
            int bottomH = child.getBottom() + params.bottomMargin;
            int rightH = child.getLeft() - params.leftMargin;
            int leftH = rightH - dividerDrawable.getIntrinsicWidth();
            dividerDrawable.setBounds(leftH, topH, rightH, bottomH);
            dividerDrawable.draw(c);
            dividerDrawable.setBounds(leftV, topV, rightV, bottomV);
            dividerDrawable.draw(c);
        }
    }


}
