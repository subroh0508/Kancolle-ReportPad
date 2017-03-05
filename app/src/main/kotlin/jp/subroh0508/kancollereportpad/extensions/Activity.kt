package jp.subroh0508.kancollereportpad.extensions

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import kotlin.reflect.KClass

/**
 * Created by subroh_0508 on 2017/03/05.
 */

fun AppCompatActivity.startService(service: KClass<*>) {
    if (Build.VERSION.SDK_INT >= 23) {
        if (!Settings.canDrawOverlays(this)) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + packageName))
            startActivityForResult(intent, 1234)
        }

        startService(Intent(this, service.java))
    } else {
        startService(Intent(this, service.java))
    }
}