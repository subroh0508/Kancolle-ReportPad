package jp.subroh0508.kancollereportpad.model

import io.realm.RealmObject

/**
 * Created by subroh_0508 on 2017/03/05.
 */
open class Weapon(
        var id: Long = 0L,
        var name: Int = 0,
        var type: String = "Large Caliber Main Gun",
        var hp: Int = 0,
        var firePower: Int = 0,
        var armor: Int = 0,
        var torpedo: Int = 0,
        var evasion: Int = 0,
        var aa: Int = 0,
        var asw: Int = 0,
        var los: Int = 0,
        var accuracy: Int = 0,
        var range: String = "Long",
        var luck: Int = 0,
        var scrapValue: Scrap = Scrap()
): RealmObject()