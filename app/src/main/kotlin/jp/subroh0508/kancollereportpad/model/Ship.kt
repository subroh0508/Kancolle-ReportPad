package jp.subroh0508.kancollereportpad.model

import io.realm.RealmObject

/**
 * Created by subroh_0508 on 2017/03/05.
 */
open class Ship(
        var id: Long = 0L,
        var name: Int = 0,
        var shipCategory: ShipCategory = ShipCategory()
) : RealmObject()