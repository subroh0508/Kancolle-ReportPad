package jp.subroh0508.kancollereportpad.extensions

import android.content.Context
import jp.subroh0508.kancollereportpad.R
import java.util.*

/**
 * Created by subroh_0508 on 2017/03/05.
 */

fun Context.dayOfWeek(date: Date) = resources.getStringArray(R.array.weeks).toList()[Calendar.getInstance().apply { time = date }.get(Calendar.DAY_OF_WEEK) - 1]

fun Date.dayOfWeek(context: Context) = getStringList(R.array.weeks)[Calendar.getInstance().apply { time = this@dayOfWeek }.get(Calendar.DAY_OF_WEEK) - 1]