package jp.subroh0508.kancollereportpad.extensions

import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.graphics.Point
import android.os.Build
import android.provider.Settings
import android.view.WindowManager

/**
 * Created by subroh_0508 on 2017/03/05.
 */

fun Service.setOverlaySettings(
        displaySize: Point? = null,
        marginX: Pair<Int, Int> = 0 to 0,
        marginY: Pair<Int, Int> = 0 to 0
): WindowManager.LayoutParams {
    var height = WindowManager.LayoutParams.WRAP_CONTENT
    var width = WindowManager.LayoutParams.WRAP_CONTENT
    var layoutX = 0
    var layoutY = 0

    displaySize?.let { size ->
        width = size.x - (marginX.first + marginX.second).dp2px(this).toInt()
        height = size.y - (marginY.first + marginY.second).dp2px(this).toInt()
        layoutX = (marginX.first - marginX.second).dp2px(this).toInt() / 2
        layoutY = (marginY.first - marginY.second).dp2px(this).toInt() / 2
    }

    return WindowManager.LayoutParams(
            width,
            height,
            WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
            PixelFormat.TRANSLUCENT
    ).apply {
        x = layoutX
        y = layoutY
    }
}

fun Service.startService(intent: Intent) {
    if (Build.VERSION.SDK_INT >= 23) {
        if (Settings.canDrawOverlays(this)) {
            startService(intent)
        }
    } else {
        startService(intent)
    }
}