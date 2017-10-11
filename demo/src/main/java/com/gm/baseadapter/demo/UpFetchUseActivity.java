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

import com.gm.base.adapter.BaseQuickAdapter;
import com.gm.baseadapter.demo.adapter.UpFetchAdapter;
import com.gm.baseadapter.demo.base.BaseActivity;
import com.gm.baseadapter.demo.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */

public class UpFetchUseActivity extends BaseActivity {
    RecyclerView mRecyclerView;
    UpFetchAdapter mAdapter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("UpFetch Use");
        setContentView(R.layout.activity_data_binding_use);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new UpFetchAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(genData());
        mAdapter.setUpFetchEnable(true);
        //start fetch when scroll to position 2, default is 1.
        mAdapter.setStartUpFetchPosition(2);
        mAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                startUpFetch();
            }
        });
    }

    private void startUpFetch() {
        count++;

        // set fetching on when start network request.
        mAdapter.setUpFetching(true);
        //get data from internet.

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.addData(0, genData());
                //set fetching off when network request ends.
                mAdapter.setUpFetching(false);
                //set fetch enable false when you don't need anymore.
                if (count > 5) {
                    mAdapter.setUpFetchEnable(false);
                }
            }
        }, 300);
    }


    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Gm";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of India's most distinguished Developer");
            list.add(movie);
        }
        return list;
    }
}
