package com.yp.cwlib.ext

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Build
import android.os.Process

object AndroidExt {
    fun Context.isMainProcess() = packageName == getCurrentProcessName()

    fun Context.getCurrentProcessName(): String? =
        if (Build.VERSION.SDK_INT >= 28) {
            Application.getProcessName()
        } else {
            val myPid = Process.myPid()
            val manager = getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
            manager?.runningAppProcesses?.find { it.pid == myPid }?.processName
        }
}