package jp.subroh0508.kancollereportpad.model

import io.realm.RealmObject
import jp.subroh0508.kancollereportpad.extensions.gs

/**
 * Created by subroh_0508 on 2017/03/05.
 */
open class ShipCategory(
        var id: Long = 0L,
        var name: Int = 0,
        var hullCodes: String = "BB"
) : RealmObject() {

    fun name(): String = gs(name)
}