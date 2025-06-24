package com.yp.cwlib.ext

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.telephony.TelephonyManager
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity

fun getAndroidDeviceId(context: Context, isDebug: Boolean): String {
    var id = getSN(context)
    if (id.isBlank()) {
        id = getAndroidId(context)
    }
    if (id.isBlank()) {
        id = "12345678910"
    }
    if (isDebug) {
        id = "ec17fefa699a3c6c"
    }
    return id
}

@SuppressLint("HardwareIds")
private fun getSN(context: Context): String {
    var deviceId = ""
    try {
        val tm = context.getSystemService(AppCompatActivity.TELEPHONY_SERVICE) as TelephonyManager
        val sn = tm.simSerialNumber
        if (!TextUtils.isEmpty(sn)) {
            deviceId = sn
        }
    } catch (e: Exception) {
        return deviceId
    }
    return deviceId
}

@Suppress("DEPRECATION")
private fun getAndroidId(context: Context): String {
    var deviceId = ""
    val androidID = Settings.System.getString(context.contentResolver, Settings.System.ANDROID_ID)
    if (!TextUtils.isEmpty(androidID)) {
        deviceId = androidID
    }
    return deviceId
}