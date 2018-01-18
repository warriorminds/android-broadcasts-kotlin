package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 18/01/2018.
 */
class SegundoBroadcastOrdenado : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val mensaje = getResultExtras(true).getString(PrimerBroadcastOrdenado.EXTRA_PRIMER_RECEIVER)
        abortBroadcast()
        Toast.makeText(context, "Segundo broadcast ordenado: $resultData\n$mensaje", Toast.LENGTH_SHORT).show()
    }
}