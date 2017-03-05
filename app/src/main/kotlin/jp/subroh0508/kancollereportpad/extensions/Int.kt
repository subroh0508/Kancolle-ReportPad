package jp.subroh0508.kancollereportpad.extensions

/**
 * Created by subroh_0508 on 2017/03/06.
 */

inline fun Int.times(body: (Int) -> Unit) {
    var index = 0
    while (index < this) {
        body(index)
        index++
    }
}