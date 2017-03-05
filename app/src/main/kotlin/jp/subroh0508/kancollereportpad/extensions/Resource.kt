package jp.subroh0508.kancollereportpad.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import jp.subroh0508.kancollereportpad.MainApplication

/**
 * Created by subroh_0508 on 2017/03/05.
 */

@ColorInt
fun gc(@ColorRes id: Int): Int {
    return ContextCompat.getColor(MainApplication.application, id)
}

fun gd(@DrawableRes id: Int): Drawable {
    return ContextCompat.getDrawable(MainApplication.application, id)
}

fun gs(@StringRes id: Int, vararg arg: Any): String {
    return MainApplication.application.baseContext.getString(id, arg)
}

fun getStringList(@ArrayRes id: Int): List<String> {
    return MainApplication.application.resources.getStringArray(id).toList()
}

fun getIntList(@ArrayRes id: Int): List<Int> {
    return MainApplication.application.resources.getIntArray(id).toList()
}

fun Int.dp2px(): Float {
    return this * MainApplication.application.resources.displayMetrics.density
}

fun Int.dp2px(context: Context): Float {
    return this * context.resources.displayMetrics.density
}