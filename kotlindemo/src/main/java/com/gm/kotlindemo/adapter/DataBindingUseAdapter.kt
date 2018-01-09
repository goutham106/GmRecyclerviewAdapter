/*
 * Copyright (C) 2018. Gowtham Parimelazhagan.
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

package com.gm.kotlindemo.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.View
import android.view.ViewGroup
import com.gm.base.adapter.BaseQuickAdapter
import com.gm.base.adapter.BaseViewHolder
import com.gm.kotlindemo.BR
import com.gm.kotlindemo.R
import com.gm.kotlindemo.entity.Movie
import com.gm.kotlindemo.entity.MoviePresenter


/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class DataBindingUseAdapter(layoutResId: Int, data: List<Movie>) : BaseQuickAdapter<Movie, DataBindingUseAdapter.MovieViewHolder>(layoutResId, data) {

    private val mPresenter: MoviePresenter = MoviePresenter()

    override fun convert(helper: MovieViewHolder, item: Movie) {
        val binding = helper.binding
        binding.setVariable(BR.movie, item)
        binding.setVariable(BR.presenter, mPresenter)
        binding.executePendingBindings()
        when (helper.layoutPosition % 2) {
            0 -> helper.setImageResource(R.id.iv, R.mipmap.m_img1)
            1 -> helper.setImageResource(R.id.iv, R.mipmap.m_img2)
        }
    }

    /*  @Override
    protected MovieViewHolder createBaseViewHolder(View view) {
        return new MovieViewHolder(view);
    }
*/
    override fun getItemView(layoutResId: Int, parent: ViewGroup): View {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater, layoutResId, parent, false) ?: return super.getItemView(layoutResId, parent)
        val view = binding.root
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding)
        return view
    }

    inner class MovieViewHolder(view: View) : BaseViewHolder(view) {

        val binding: ViewDataBinding
            get() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
    }
}
