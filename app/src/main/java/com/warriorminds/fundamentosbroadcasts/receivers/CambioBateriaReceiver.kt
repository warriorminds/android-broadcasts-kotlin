package com.warriorminds.fundamentosbroadcasts.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

/**
 * Created by rodrigo.guerrero on 17/01/2018.
 */
class CambioBateriaReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var nivel = -1
        var nivelMaximo = -1
        var temperatura = -1
        var accion = ""
        var conectado = ""
        var estado = ""

        intent?.let {
            nivel = it.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            nivelMaximo = it.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            temperatura = it.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1)
            accion = it.action
            var conectadoExtra = it.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            conectado = if (conectadoExtra == 0) "No" else "Sí"
            var estadoExtra = it.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            when (estadoExtra) {
                BatteryManager.BATTERY_STATUS_CHARGING -> estado = "Cargando"
                BatteryManager.BATTERY_STATUS_DISCHARGING -> estado = "Descargando"
                BatteryManager.BATTERY_STATUS_FULL -> estado = "Batería Cargada"
                BatteryManager.BATTERY_STATUS_NOT_CHARGING -> estado = "No Cargando"
            }
        }

        Toast.makeText(context, "Acción: $accion \nEstado: $estado\nConectado: $conectado\nNivel: $nivel\nNivel Máximo: $nivelMaximo\nTemperatura: " +
                "$temperatura", Toast.LENGTH_SHORT).show()
    }
}