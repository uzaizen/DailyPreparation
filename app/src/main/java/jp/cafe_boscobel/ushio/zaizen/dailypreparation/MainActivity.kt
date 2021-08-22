package jp.cafe_boscobel.ushio.zaizen.dailypreparation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.System.exit
import java.util.*

var maxCustomerInt:Int = 0

class MainActivity : AppCompatActivity() {

    private lateinit var mRealm:Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("uztest","phase0")

        maxCustomerButton.setOnClickListener {
            val editText1 = maxCustomer.text
            maxCustomerInt = editText1.toString().toInt()
            Log.d("uztest",editText1.toString())
        }

        Log.d("uztest","phase2")

        button1.setOnClickListener {view ->
            val intent = Intent(this, soupInputActivity::class.java)
            startActivity(intent)}

        Log.d("uztest","phase3")

        button2.setOnClickListener {view ->
            val intent = Intent(this, vegeInputActivity::class.java)
            startActivity(intent)}

        Log.d("uztest","phase4")

        end_button.setOnClickListener { view ->
            writedata()
            readdatafortest()
        }

        Log.d("uztest","phase5")

//        deletedata()
    }

    override fun onDestroy(){
        super.onDestroy()
        mRealm.close()
    }

    private fun writedata() {
        mRealm = Realm.getDefaultInstance()
        val dpdata = DailyPreparation()
        dpdata.MaxCustomers = maxCustomerInt
        dpdata.TomatoSoup = 1600
        dpdata.CreamSoup = 1600
        dpdata.PotatoSalad = 500
        dpdata.CarrotRape = 200
        dpdata.date = Date()
//        dpdata.id +=1

        Log.d("uztest","writing data1")
        mRealm.beginTransaction()
        Log.d("uztest","writing data 2")
        mRealm.insert(dpdata)
        Log.d("uztest","writing data 3")
        mRealm.commitTransaction()
        Log.d("uztest","writing data4")
        Log.d("uztest", "writtendata is ${mRealm.where<DailyPreparation>().findAll()}")

        mRealm.close()
    }

    private fun readdatafortest() {

        mRealm = Realm.getDefaultInstance()

        val datasets = mRealm.where<DailyPreparation>().findAll()
        Log.d("uztest", "readdata is:$datasets")

        mRealm.close()
//        Log.d("uztest",datasets.MaxCustomers.toString())
    }

    private fun deletedata()  {
        mRealm = Realm.getDefaultInstance()

        val datasets = mRealm.where<DailyPreparation>().findAll()
        datasets.deleteAllFromRealm()
        mRealm.commitTransaction()
        Log.d("uztest","deleted data")
        mRealm.close()

    }

}