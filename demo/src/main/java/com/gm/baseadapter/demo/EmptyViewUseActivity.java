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

package com.gm.baseadapter.demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.gm.baseadapter.demo.adapter.QuickAdapter;
import com.gm.baseadapter.demo.base.BaseActivity;
import com.gm.baseadapter.demo.data.DataServer;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class EmptyViewUseActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private QuickAdapter mQuickAdapter;
    private View notDataView;
    private View errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("EmptyView Use");
        setContentView(R.layout.activity_empty_view_use);
        findViewById(R.id.btn_reset).setOnClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        notDataView = getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRecyclerView.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        errorView = getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) mRecyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });
        initAdapter();
        onRefresh();
    }

    private void initAdapter() {
        mQuickAdapter = new QuickAdapter(0);
        mRecyclerView.setAdapter(mQuickAdapter);
    }

    @Override
    public void onClick(View v) {
        mError = true;
        mNoData = true;
        mQuickAdapter.setNewData(null);
        onRefresh();
    }

    private boolean mError = true;
    private boolean mNoData = true;

    private void onRefresh() {
        mQuickAdapter.setEmptyView(R.layout.loading_view, (ViewGroup) mRecyclerView.getParent());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mError) {
                    mQuickAdapter.setEmptyView(errorView);
                    mError = false;
                } else {
                    if (mNoData) {
                        mQuickAdapter.setEmptyView(notDataView);
                        mNoData = false;
                    } else {
                        mQuickAdapter.setNewData(DataServer.getSampleData(10));
                    }
                }
            }
        }, 1000);
    }
}
