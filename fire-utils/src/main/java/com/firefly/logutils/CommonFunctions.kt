package com.firefly.logutils

import android.util.Log

const val TAG = "FireLog"

fun String.logI(tag: String? = null) {
    Log.i(tag?: TAG, this)
}

fun String.logD(tag: String? = null) {
    Log.d(tag?: TAG, this)
}

fun Throwable?.logE(message: String = "", tag: String? = null) {
    Log.e(tag?: TAG, message, this)
}