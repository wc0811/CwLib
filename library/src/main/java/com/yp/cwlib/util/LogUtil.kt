package com.yp.cwlib.util

import android.util.Log

fun setLog(isLogAble: Boolean = true, tag: String? = "CWang", msg: String? = "") {
    var message = "系统异常，请练习管理员"
    msg?.let {
        message = it
    }
    if (isLogAble) {
        Log.v(tag, message)
    }
}