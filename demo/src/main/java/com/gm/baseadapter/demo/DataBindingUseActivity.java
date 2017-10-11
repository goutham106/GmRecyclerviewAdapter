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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gm.base.adapter.BaseQuickAdapter;
import com.gm.baseadapter.demo.adapter.DataBindingUseAdapter;
import com.gm.baseadapter.demo.base.BaseActivity;
import com.gm.baseadapter.demo.entity.Movie;
import com.gm.baseadapter.demo.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class DataBindingUseActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    DataBindingUseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("DataBinding Use");
        setContentView(R.layout.activity_data_binding_use);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new DataBindingUseAdapter(R.layout.item_movie, genData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        mAdapter.setNotDoAnimationCount(3);
        mAdapter.isFirstOnly(false);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemClick");
            }
        });
        mAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemChildLongClick");
                return true;
            }
        });
        mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemLongClick");
                return true;
            }
        });
    }


    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "GM";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of India's most distinguished developer");
            list.add(movie);
        }
        return list;
    }
}
