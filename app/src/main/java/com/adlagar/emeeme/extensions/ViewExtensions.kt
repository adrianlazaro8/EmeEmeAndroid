package com.adlagar.emeeme.extensions

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.google.android.material.snackbar.Snackbar


fun View.showSnackbar(message: Int, time: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, this.context.getString(message), time).show()
}

fun View.fadeOut() {
    val anim = AlphaAnimation(1.0f, 0.0f)
    anim.duration = 500
    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
        }

        override fun onAnimationEnd(animation: Animation?) {
            visibility = View.GONE
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }
    })
    startAnimation(anim)
}

fun View.fadeIn() {
    val anim = AlphaAnimation(0.0f, 1.0f)
    anim.duration = 500
    anim.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation?) {
            visibility = View.VISIBLE
        }

        override fun onAnimationEnd(animation: Animation?) {
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }
    })
    startAnimation(anim)
}