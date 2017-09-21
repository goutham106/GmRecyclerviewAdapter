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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.gm.baseadapter.demo.R;
import com.gm.baseadapter.demo.data.DataServer;
import com.gm.baseadapter.demo.entity.Status;

import java.util.List;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */

public class DefAdpater extends RecyclerView.Adapter<DefAdpater.ViewHolder> {
    private final List<Status> sampleData = DataServer.getSampleData(100);
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public DefAdpater(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.layout_animation, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Status status = sampleData.get(position);
        holder.name.setText(status.getUserName());
        holder.text.setText(status.getText());
        holder.date.setText(status.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return sampleData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;
        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tweetText);
            name = (TextView) itemView.findViewById(R.id.tweetName);
            date = (TextView) itemView.findViewById(R.id.tweetDate);

        }
    }
}