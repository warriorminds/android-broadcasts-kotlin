package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 18/01/2018.
 */
class TercerBroadcastOrdenado : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Tercer broadcast ordenado", Toast.LENGTH_SHORT).show()
    }
}