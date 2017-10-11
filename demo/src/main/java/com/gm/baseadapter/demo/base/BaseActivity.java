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

package com.gm.baseadapter.demo.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gm.baseadapter.demo.R;
import com.orhanobut.logger.Logger;


/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class BaseActivity extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    /**
     * Title flag getSupportActionBar ().
     **/
    private TextView title;
    private ImageView back;
    private LinearLayout rootLayout;

    protected void setTitle(String msg) {
        if (title != null) {
            title.setText(msg);
        }
    }

    /**
     * sometime you want to define back event
     */
    protected void setBackBtn() {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            Logger.t(TAG).e("back is null ,please check out");
        }

    }

    protected void setBackClickListener(View.OnClickListener l) {
        if (back != null) {
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(l);
        } else {
            Logger.t(TAG).e("back is null ,please check out");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // It is more effective to declare a transparent status bar directly in the code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // This sentence is very critical, pay attention to the method is to call the parent class
        super.setContentView(R.layout.activity_base);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        if (getSupportActionBar() != null) {
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.title);
    }


    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        if (rootLayout == null) return;
        rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        initToolbar();
    }
}
