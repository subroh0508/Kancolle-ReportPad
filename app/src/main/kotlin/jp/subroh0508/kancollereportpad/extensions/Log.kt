package jp.subroh0508.kancollereportpad.extensions

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * Created by subroh_0508 on 2017/03/05.
 */

fun showToast(context: Context, message: String?) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun showToast(context: Context, messageRes: Int) {
    Toast.makeText(context, messageRes, Toast.LENGTH_LONG).show()
}

fun d(tag: String, arg: Any?) {
    Log.d(tag, arg?.toString() ?: "null")
}