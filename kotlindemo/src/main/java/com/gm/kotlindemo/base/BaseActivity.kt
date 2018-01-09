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

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.gm.kotlindemo.R

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
open class BaseActivity : AppCompatActivity() {
    /**
     * Title flag getSupportActionBar ().
     **/
    private var title: TextView? = null
    private var back: ImageView? = null
    protected val TAG = this.javaClass.simpleName

    protected fun setTitle(msg: String) {
        title?.text = msg
    }

    /**
     * sometime you want to define back event
     */
    protected fun setBackBtn() {
        back?.visibility = View.VISIBLE
        back?.setOnClickListener { finish() }

    }

    protected fun setBackClickListener(l: View.OnClickListener) {
        back?.visibility = View.VISIBLE
        back?.setOnClickListener { finish() }

    }

    private var rootLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // It is more effective to declare a transparent status bar directly in the code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        // This sentence is very critical, pay attention to the method is to call the parent class
        super.setContentView(R.layout.activity_base)
        initToolbar()
    }

    private fun initToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        // Enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        back = findViewById(R.id.img_back) as ImageView
        title = findViewById(R.id.title) as TextView
    }


    override fun setContentView(layoutId: Int) {
        setContentView(View.inflate(this, layoutId, null))
    }

    override fun setContentView(view: View) {
        rootLayout = findViewById(R.id.root_layout) as LinearLayout
        if (rootLayout == null) return
        rootLayout?.addView(view, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        initToolbar()
    }
}
