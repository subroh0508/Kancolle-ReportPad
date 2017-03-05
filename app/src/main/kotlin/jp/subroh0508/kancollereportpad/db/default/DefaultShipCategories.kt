package jp.subroh0508.kancollereportpad.db.default

import android.content.Context
import io.realm.Realm
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.extensions.times
import jp.subroh0508.kancollereportpad.model.ShipCategory

/**
 * Created by subroh_0508 on 2017/03/05.
 */
class DefaultShipCategories(val context: Context) {
    val realm: Realm = Realm.getDefaultInstance()
    val shipCategories: List<Int> by lazy {
        context.resources.obtainTypedArray(R.array.shipCategories).let {
            val categories = arrayListOf<Int>()
            it.length().times { index -> categories.add(it.getResourceId(index, 0)) }

            categories
        }
    }
    val hullCodes: List<String> by lazy { context.resources.getStringArray(R.array.hullCodes).toList() }

    fun load() {
        val category = realm.where(ShipCategory::class.java).findFirst()

        if (category == null) {
            realm.beginTransaction()
            shipCategories.forEachIndexed { index, category ->
                realm.copyToRealm(ShipCategory(index.toLong(), category, hullCodes[index]))
            }
            realm.commitTransaction()
        }
    }
}