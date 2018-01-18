package com.warriorminds.fundamentosbroadcasts.receivers

import android.app.Activity.RESULT_OK
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 18/01/2018.
 */
class PrimerBroadcastOrdenado : BroadcastReceiver() {

    companion object {
        val EXTRA_PRIMER_RECEIVER = "extraPrimerReceiver"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = Bundle()
        bundle.putString(EXTRA_PRIMER_RECEIVER, "Extra del primer receiver.")
        setResult(RESULT_OK, "Mensaje agregado en el primer receiver", bundle)
        Toast.makeText(context, "Primer broadcast ordenado", Toast.LENGTH_SHORT).show()
    }
}