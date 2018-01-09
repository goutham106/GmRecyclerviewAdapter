package com.gm.kotlindemo.animation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import com.gm.base.adapter.animation.BaseAnimation

/**
 * Author     : Gowtham
 * Email      : goutham.gm11@gmail.com
 * Github     : https://github.com/goutham106
 * Created on : 1/09/18.
 */
class CustomAnimation : BaseAnimation {

    override fun getAnimators(view: View): Array<Animator> {
        return arrayOf(ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.1f, 1f),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.1f, 1f))

    }
}
