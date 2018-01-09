package com.gm.kotlindemo

import android.app.Application
import com.gm.kotlindemo.util.Utils
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        Utils.init(this)
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }
    }

    companion object {
        var instance: MyApplication? = null
            private set
    }
}
