package com.example.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val receiver:BatteryReceiver = BatteryReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_receiver.setOnClickListener{
            sendBroadcast(Intent(MyAction))
        }
    }

    override fun onResume() {
        super.onResume()
        val filter:IntentFilter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(MyAction)
        this.registerReceiver(receiver,filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }
}