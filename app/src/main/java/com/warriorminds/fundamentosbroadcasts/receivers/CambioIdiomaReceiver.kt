package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 17/01/2018.
 */
class CambioIdiomaReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var accion = ""
        intent?.let {
            accion = it.action
        }
        Toast.makeText(context, "Acción: $accion", Toast.LENGTH_SHORT).show()
    }
}