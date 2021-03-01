package am.ithd.presentation.util

import am.ithd.presentation.R
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment

fun Fragment.showErrorDialog(title: String?, message: String) {
    AlertDialog.Builder(context).setTitle(title).setMessage(message)
        .setNeutralButton("OK") { dialog: DialogInterface, _: Int ->
            dialog.dismiss()
        }.show()
}

fun (() -> Any?).delayed(delayMills: Long) {
    Handler(Looper.getMainLooper()).postDelayed({
        this()
    }, delayMills)
}