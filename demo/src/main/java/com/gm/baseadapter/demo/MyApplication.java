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

import android.app.Application;

import com.gm.baseadapter.demo.util.ToastUtils;
import com.gm.baseadapter.demo.util.Utils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 9/20/17.
 */
public class MyApplication extends Application {
    private static MyApplication appContext;

    public static MyApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext =this;
        Utils.init(this);
        ToastUtils.init(true);
        if (BuildConfig.DEBUG) {
            Logger
                    .init("GmRecyclerViewBaseAdapter")                 // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                    .methodOffset(2)                // default 0
            ; //default AndroidLogAdapter


        }
    }
}
