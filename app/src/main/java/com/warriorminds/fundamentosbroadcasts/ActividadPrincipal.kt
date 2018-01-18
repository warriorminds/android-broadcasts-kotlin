package com.warriorminds.fundamentosbroadcasts

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.widget.Toast
import com.warriorminds.fundamentosbroadcasts.receivers.CambioBateriaReceiver
import com.warriorminds.fundamentosbroadcasts.receivers.ModoAvionReceiver
import com.warriorminds.fundamentosbroadcasts.receivers.PrimerReceiver
import com.warriorminds.fundamentosbroadcasts.receivers.ReceiverAsincrono
import kotlinx.android.synthetic.main.actividad_principal.*
import java.util.*

class ActividadPrincipal : AppCompatActivity() {

    companion object {
        val NUMERO_ALEATORIO = "numeroAleatorio"
    }

    private val ACCION_PRIMER_BROADCAST = "com.warriorminds.broadcast.PRIMER_BROADCAST"
    private val ACCION_BROADCAST_ORDENADO = "com.warriorminds.broadcast.ACCION_ORDENADOS"
    private val ACCION_BROADCAST_ASINCRONO = "com.warriorminds.broadcast.ACCION_ASINCRONO"

    private val primerReceiver = PrimerReceiver()
    private val modoAvionReceiver = ModoAvionReceiver()
    private val cambioBateriaReceiver = CambioBateriaReceiver()
    private val receiverAsincrono = ReceiverAsincrono()

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
        botonEnviarBroadcastOrdenado.setOnClickListener {
            enviarBroadcastOrdenado()
        }
        botonBroadcastAsicrono.setOnClickListener {
            enviarBroadcastAsíncrono()
        }
    }

    override fun onStart() {
        super.onStart()
        val modoAvionIntentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(modoAvionReceiver, modoAvionIntentFilter)

        val cambioBateriaIntentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(cambioBateriaReceiver, cambioBateriaIntentFilter)

        val asincronoIntentFilter = IntentFilter(ACCION_BROADCAST_ASINCRONO)
        registerReceiver(receiverAsincrono, asincronoIntentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(modoAvionReceiver)
        unregisterReceiver(cambioBateriaReceiver)
        unregisterReceiver(receiverAsincrono)
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

    private fun enviarBroadcastOrdenado() {
        val intent = Intent(ACCION_BROADCAST_ORDENADO)
        sendOrderedBroadcast(intent, null)
    }

    private fun enviarBroadcastAsíncrono() {
        val intent = Intent(ACCION_BROADCAST_ASINCRONO)
        sendBroadcast(intent)
    }
}
