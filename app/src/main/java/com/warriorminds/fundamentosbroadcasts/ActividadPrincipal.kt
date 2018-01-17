package com.warriorminds.fundamentosbroadcasts

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.widget.Toast
import com.warriorminds.fundamentosbroadcasts.receivers.PrimerReceiver
import kotlinx.android.synthetic.main.actividad_principal.*
import java.util.*

class ActividadPrincipal : AppCompatActivity() {

    companion object {
        val NUMERO_ALEATORIO = "numeroAleatorio"
    }

    private val ACCION_PRIMER_BROADCAST = "com.warriorminds.broadcast.PRIMER_BROADCAST"
    private val primerReceiver = PrimerReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_principal)

        botonRegistrarPrimerBroadcast.setOnClickListener {
            registrarPrimerBroadcast()
        }
        botonDesregistrarPrimerBroadcast.setOnClickListener {
            desregistrarPrimerBroadcast()
        }
        botonEnviarPrimerBroadcast.setOnClickListener {
            enviarPrimerBroadcast()
        }
    }

    private fun registrarPrimerBroadcast() {
        val intentFilter = IntentFilter(ACCION_PRIMER_BROADCAST)
        LocalBroadcastManager.getInstance(this).registerReceiver(primerReceiver, intentFilter)
        Toast.makeText(this, "Primer Receiver registrado.", Toast.LENGTH_SHORT).show()
    }

    private fun desregistrarPrimerBroadcast() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(primerReceiver)
        Toast.makeText(this, "Primer Receiver desregistrado.", Toast.LENGTH_SHORT).show()
    }

    private fun enviarPrimerBroadcast() {
        val intent = Intent()
        intent.action = ACCION_PRIMER_BROADCAST
        intent.putExtra(NUMERO_ALEATORIO, Random().nextInt(1000))
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }
}
