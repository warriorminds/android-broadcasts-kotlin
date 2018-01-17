package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.warriorminds.fundamentosbroadcasts.ActividadPrincipal

/**
 * Created by rodrigo.guerrero on 17/01/2018.
 */
class PrimerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var numeroAleatorio = 0
        intent?.let {
            numeroAleatorio = it.getIntExtra(ActividadPrincipal.NUMERO_ALEATORIO, 0)
        }
        Toast.makeText(context, "Primer Receiver: broadcast recibido con número aleatorio $numeroAleatorio.", Toast.LENGTH_SHORT).show()
    }
}