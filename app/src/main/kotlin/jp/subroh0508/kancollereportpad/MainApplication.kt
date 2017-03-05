package jp.subroh0508.kancollereportpad

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by subroh_0508 on 2017/03/05.
 */
class MainApplication : Application() {
    companion object {
        lateinit var application: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().build())
    }
}