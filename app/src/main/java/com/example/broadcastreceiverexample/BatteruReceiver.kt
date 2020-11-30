package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

const val MyAction:String = "example.action.ACTION_MY_BROADCAST"
class BatteryReceiver:BroadcastReceiver(){
    /**
     * BroadcastReceiver는 context를 override하지 않았기에
     * 본인의 context는 아니며, 외부의 context를 onReceive를 통해 전달받습니다.
     * */
    override fun onReceive(context: Context, intent: Intent) {
        val msg = if(intent.action.equals(Intent.ACTION_POWER_CONNECTED)) {
            "전원 연결"
        }else if(intent.action.equals(MyAction)){
            "방송"
        }else{
            "전원 해제"
        }
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}