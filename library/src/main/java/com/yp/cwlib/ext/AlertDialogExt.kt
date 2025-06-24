package com.yp.cwlib.ext

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yp.cwlib.R

fun Context.showDialog(
    title: String? = null,
    message: String? = null,
    positiveButtonText: String? = getString(R.string.sure),
    negativeButtonText: String? = getString(R.string.cancel),
    positiveButtonClick: (() -> Unit)? = null,
    negativeButtonClick: (() -> Unit)? = null
) {
    val dialog = MaterialAlertDialogBuilder(this)
    title?.let {
        dialog.setTitle(it)
    }
    message?.let {
        dialog.setMessage(it)
    }
    dialog.setPositiveButton(positiveButtonText) { dlg, _ ->
        positiveButtonClick?.invoke()
        dlg.dismiss()
    }
    dialog.setNegativeButton(negativeButtonText) { dlg, _ ->
        negativeButtonClick?.invoke()
        dlg.dismiss()
    }.create()
    dialog.show()
}
