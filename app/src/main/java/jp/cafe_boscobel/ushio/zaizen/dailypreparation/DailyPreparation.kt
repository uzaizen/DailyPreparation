package jp.cafe_boscobel.ushio.zaizen.dailypreparation

import java.io.Serializable
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey
import java.util.*

open class DailyPreparation: RealmObject(), Serializable {
    @Index
    var date: Date = Date()

    var MaxCustomers:Int = 0
    var TomatoSoup:Int =0
    var CreamSoup:Int =0
    var PotatoSalad:Int =0
    var CarrotRape:Int =0

/*    @Index
    var id: Int =0

 */

}