package jp.cafe_boscobel.ushio.zaizen.dailypreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_soup_input.*

class soupInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soup_input)

        var souptotalvolume = maxCustomerInt * 120
        souprequired.text=souptotalvolume.toString()
        Log.d("uztest","soup input activity")
    }
}