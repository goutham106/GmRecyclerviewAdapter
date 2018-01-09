package com.gm.kotlindemo.util

import android.os.Handler
import android.os.Looper
import android.support.annotation.StringRes
import android.widget.Toast

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class ToastUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        private var sToast: Toast? = null
        private val sHandler = Handler(Looper.getMainLooper())
        private var isJumpWhenMore: Boolean = false

        /**
         * Toast initiation
         *
         * @param isJumpWhenMore When the continuous pop up toast, is to pop up the new toast or only modify the text content
         *                       <p>{@code true}: Pop new toast<br>{@code false}: Only modify the text content</p>
         *                       <p>If it is{@code false}Can be used to show any time toast</p>
         */
        fun init(isJumpWhenMore: Boolean) {
            ToastUtils.isJumpWhenMore = isJumpWhenMore
        }

        /**
         * Safely show short toast
         *
         * @param text text
         */
        fun showShortToastSafe(text: CharSequence) {
            sHandler.post { toast(text, Toast.LENGTH_SHORT) }
        }

        /**
         * Safely show short toast
         *
         * @param resId Resource Id
         */
        fun showShortToastSafe(@StringRes resId: Int) {
            sHandler.post { showToast(resId, Toast.LENGTH_SHORT) }
        }

        /**
         * Safely show short toast
         *
         * @param resId Resource Id
         * @param args  parameter
         */
        fun showShortToastSafe(@StringRes resId: Int, vararg args: Any) {
            sHandler.post { showToast(resId, Toast.LENGTH_SHORT, *args) }
        }

        /**
         * Safely show short toast
         *
         * @param format format
         * @param args   parameter
         */
        fun showShortToastSafe(format: String, vararg args: Any) {
            sHandler.post { showToast(format, Toast.LENGTH_SHORT, *args) }
        }

        /**
         * Safely show long toast
         *
         * @param text text
         */
        fun showLongToastSafe(text: CharSequence) {
            sHandler.post { toast(text, Toast.LENGTH_LONG) }
        }

        /**
         * Safely show long toast
         *
         * @param resId Resource Id
         */
        fun showLongToastSafe(@StringRes resId: Int) {
            sHandler.post { showToast(resId, Toast.LENGTH_LONG) }
        }

        /**
         * Safely show long toast
         *
         * @param resId Resource Id
         * @param args  parameter
         */
        fun showLongToastSafe(@StringRes resId: Int, vararg args: Any) {
            sHandler.post { showToast(resId, Toast.LENGTH_LONG, *args) }
        }

        /**
         * Safely show long toast
         *
         * @param format format
         * @param args   parameter
         */
        fun showLongToastSafe(format: String, vararg args: Any) {
            sHandler.post { showToast(format, Toast.LENGTH_LONG, *args) }
        }

        /**
         * Show short toast
         *
         * @param text text
         */
        fun showShortToast(text: CharSequence) {
            toast(text, Toast.LENGTH_SHORT)
        }

        /**
         * Show short toast
         *
         * @param resId Resource Id
         */
        fun showShortToast(@StringRes resId: Int) {
            showToast(resId, Toast.LENGTH_SHORT)
        }

        /**
         * Show short toast
         *
         * @param resId Resource Id
         * @param args  parameter
         */
        fun showShortToast(@StringRes resId: Int, vararg args: Any) {
            showToast(resId, Toast.LENGTH_SHORT, *args)
        }

        /**
         * Show short toast
         *
         * @param format format
         * @param args   parameter
         */
        fun showShortToast(format: String, vararg args: Any) {
            showToast(format, Toast.LENGTH_SHORT, *args)
        }

        /**
         * Show long toast
         *
         * @param text text
         */
        fun showLongToast(text: CharSequence) {
            toast(text, Toast.LENGTH_LONG)
        }

        /**
         * Show long toast
         *
         * @param resId Resource Id
         */
        fun showLongToast(@StringRes resId: Int) {
            showToast(resId, Toast.LENGTH_LONG)
        }

        /**
         * Show long toast
         *
         * @param resId Resource Id
         * @param args  parameter
         */
        fun showLongToast(@StringRes resId: Int, vararg args: Any) {
            showToast(resId, Toast.LENGTH_LONG, *args)
        }

        /**
         * Show long toast
         *
         * @param format format
         * @param args   parameter
         */
        fun showLongToast(format: String, vararg args: Any) {
            showToast(format, Toast.LENGTH_LONG, *args)
        }

        /**
         * Show toast
         *
         * @param resId    Resource Id
         * @param duration Show duration
         */
        private fun showToast(@StringRes resId: Int, duration: Int) {
            showToast(Utils.getContext().resources.getText(resId).toString(), duration)
        }

        /**
         * Show toast
         *
         * @param resId    Resource Id
         * @param duration Show duration
         * @param args     parameter
         */
        private fun showToast(@StringRes resId: Int, duration: Int, vararg args: Any) {
            showToast(String.format(Utils.getContext().resources.getString(resId), *args), duration)
        }

        /**
         * Show toast
         *
         * @param format   format
         * @param duration Show duration
         * @param args     parameter
         */
        private fun showToast(format: String, duration: Int, vararg args: Any) {
            toast(String.format(format, *args), duration)
        }

        /**
         * toast
         *
         * @param text     text
         * @param duration Show duration
         */
        private fun toast(text: CharSequence, duration: Int) {
            if (isJumpWhenMore) cancelToast()
            if (sToast == null) {
                sToast = Toast.makeText(Utils.getContext(), text, duration)
            } else {
                sToast!!.setText(text)
                sToast!!.duration = duration
            }
            sToast!!.show()
        }

        /**
         * Cancel toast show
         */
        fun cancelToast() {
            if (sToast != null) {
                sToast!!.cancel()
                sToast = null
            }
        }
    }
}
