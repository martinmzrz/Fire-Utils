package com.firefly.viewutils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.AnimRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import kotlin.math.roundToInt


fun Context.dpsToPixels(dps: Int): Int{
    val resources = this.resources
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dps.toFloat(),
        resources.displayMetrics
    ).toInt()
}

fun Context.pixelsToDps(pixels: Int): Int {
    return (pixels / (this.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View.isGone(): Boolean {
    return this.visibility == View.GONE
}

fun View?.visible() {
    this?.visibility = View.VISIBLE
}

fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
}

fun View?.invisible() {
    this?.visibility = View.INVISIBLE
}

fun Fragment.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this.requireContext(), resId, duration).show()
}

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this.requireContext(), message, duration).show()
}

fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, resId, duration).show()
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()
}

fun View.runAnimation(
    @AnimRes animationRes: Int,
    ondEndEvent: ((view: View) -> Unit)? = null,
    onStartEvent: ((view: View) -> Unit)? = null,
    onRepeatEvent: ((view: View) -> Unit)? = null,
    fillAfter: Boolean = false
){
    val animation = AnimationUtils.loadAnimation(context, animationRes)

    animation.setAnimationListener(object: AnimationListener{
        override fun onAnimationStart(animation: Animation?) {
            onStartEvent?.invoke(this@runAnimation)
        }

        override fun onAnimationEnd(animation: Animation?) {
            ondEndEvent?.invoke(this@runAnimation)
            if(fillAfter){
                animation?.fillAfter = true
            }
        }

        override fun onAnimationRepeat(animation: Animation?) {
            onRepeatEvent?.invoke(this@runAnimation)
        }
    })

    startAnimation(animation)
}

