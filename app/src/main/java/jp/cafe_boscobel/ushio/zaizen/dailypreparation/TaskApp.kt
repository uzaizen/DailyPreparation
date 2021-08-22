package jp.cafe_boscobel.ushio.zaizen.dailypreparation

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class TaskApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

    //設定
        val config = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
              //.readOnly()
                .build()
        Realm.setDefaultConfiguration(config)

 /*       // 設定
        val config = RealmConfiguration.Builder()
                .name("myrealm.realm")
                .encryptionKey(getMyKey())
                .schemaVersion(42)
                .modules(MySchemaModule())
                .migration(MyMigration())
                .readOnly()
                .inMemory()
                .build()
        Realm.setDefaultConfiguration(config)
  */
    }
}