package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 17/01/2018.
 */
class ModoAvionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var accion = ""
        var estado = false

        intent?.let {
            accion = intent.action
            estado = intent.getBooleanExtra("state", false)
        }

        Toast.makeText(context, "Acción: $accion, Estado: ${if (estado) "Encendido" else "Apagado"}", Toast.LENGTH_SHORT).show()
    }
}