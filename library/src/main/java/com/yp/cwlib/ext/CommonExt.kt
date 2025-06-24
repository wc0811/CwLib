package com.yp.cwlib.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun View.hideKeyboard(context: Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

internal fun Calendar.formatDate(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(this.time)
}
