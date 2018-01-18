package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 18/01/2018.
 */
class ReceiverAsincrono : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val pendingResult = goAsync()
        TareaAsincrona(pendingResult, context).execute()
    }
}

class TareaAsincrona(val pendingResult: BroadcastReceiver.PendingResult, val context: Context?) : AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg params: Unit?) {
        Thread.sleep(2000)
        pendingResult.finish()
    }

    override fun onPostExecute(result: Unit) {
        Toast.makeText(context, "Tarea asíncrona terminada", Toast.LENGTH_SHORT).show()
    }
}