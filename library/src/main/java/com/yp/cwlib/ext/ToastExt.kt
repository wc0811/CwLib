package com.yp.cwlib.ext

import android.app.Activity
import android.widget.Toast
import com.yp.cwlib.util.setLog

fun showToast(activity: Activity, msg: String? = null) {
    val delayMillis = 2 * 1000L
    var currentMillis = 0L
    if (System.currentTimeMillis() - currentMillis < delayMillis) {
        return
    }
    if (!msg.isNullOrBlank()) {
        setLog(msg = msg)
        activity.runOnUiThread {
            currentMillis = System.currentTimeMillis()
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
