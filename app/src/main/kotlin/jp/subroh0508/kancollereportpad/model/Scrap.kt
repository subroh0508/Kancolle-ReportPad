package jp.subroh0508.kancollereportpad.model

import io.realm.RealmObject

/**
 * Created by subroh_0508 on 2017/03/06.
 */
open class Scrap(
        var fuel: Int = 0,
        var ammunition: Int = 0,
        var steel: Int = 0,
        var bauxite: Int = 0
) : RealmObject()