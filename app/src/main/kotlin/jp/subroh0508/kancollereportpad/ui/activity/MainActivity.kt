package jp.subroh0508.kancollereportpad.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.realm.Realm
import jp.subroh0508.kancollereportpad.R
import jp.subroh0508.kancollereportpad.db.default.DefaultShipCategories
import jp.subroh0508.kancollereportpad.model.ShipCategory
import jp.subroh0508.kancollereportpad.service.MainService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val realm: Realm by lazy { Realm.getDefaultInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (button.text.toString() == "start service") {
                MainService.start(this)
                button.text = "stop service"
            } else {
                MainService.stop(this)
                button.text = "start service"
            }
        }

        load.setOnClickListener { DefaultShipCategories(this).load() }

        findAll.setOnClickListener {
            val categories = realm.where(ShipCategory::class.java).findAll()
            shipCategories.text = categories.map { "${it.name()}/${it.hullCodes}" }.joinToString("\n")
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
