package com.gm.kotlindemo.adapter

import com.gm.kotlindemo.R
import com.gm.kotlindemo.base.BaseDataBindingAdapter
import com.gm.kotlindemo.databinding.ItemMovieBinding
import com.gm.kotlindemo.entity.Movie

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
open class UpFetchAdapter : BaseDataBindingAdapter<Movie, ItemMovieBinding>(R.layout.item_movie) {

    protected override fun convert(binding: ItemMovieBinding, item: Movie) {
        binding.movie = item
    }
}
