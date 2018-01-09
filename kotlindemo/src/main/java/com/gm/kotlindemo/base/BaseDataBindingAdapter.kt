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

package com.gm.kotlindemo.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup
import com.gm.base.adapter.BaseQuickAdapter

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
abstract class BaseDataBindingAdapter<T, Binding : ViewDataBinding> : BaseQuickAdapter<T, BaseBindingViewHolder<Binding>> {


    constructor(@LayoutRes layoutResId: Int, data: List<T>?) : super(layoutResId, data) {}

    constructor(data: List<T>?) : super(data) {}

    constructor(@LayoutRes layoutResId: Int) : super(layoutResId) {}

    override fun createBaseViewHolder(view: View): BaseBindingViewHolder<Binding> {
        return BaseBindingViewHolder(view)
    }

    override fun createBaseViewHolder(parent: ViewGroup, layoutResId: Int): BaseBindingViewHolder<Binding> {
        val binding = DataBindingUtil.inflate<Binding>(mLayoutInflater, layoutResId, parent, false)
        val view: View
        if (binding == null) {
            view = getItemView(layoutResId, parent)
        } else {
            view = binding.root
        }
        val holder = BaseBindingViewHolder<Binding>(view)
        holder.binding = (binding)
        return holder
    }

    override fun convert(helper: BaseBindingViewHolder<Binding>, item: T) {
        convert(helper.binding!!, item)
        helper.binding!!.executePendingBindings()
    }

    protected abstract fun convert(binding: Binding, item: T)
}
