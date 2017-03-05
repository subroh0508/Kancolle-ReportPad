package jp.subroh0508.kancollereportpad.model.arsenal

import io.realm.RealmObject
import jp.subroh0508.kancollereportpad.model.Weapon

/**
 * Created by subroh_0508 on 2017/03/05.
 */
open class ImprovementWeapon(
        var id: Long = 0L,
        var weapon: Weapon = Weapon()
) : RealmObject()