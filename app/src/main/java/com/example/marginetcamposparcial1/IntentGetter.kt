package com.example.marginetcamposparcial1

import android.content.Context
import android.content.Intent

class IntentGetter {
    fun getIntent(nombre: String, deporte: String, actividad: String, context: Context) {
        val intent = Intent(context, ThirdActivity::class.java)
        intent.putExtra("nombre", nombre)
        intent.putExtra("deporte", deporte)
        intent.putExtra("actividad", actividad)
        context.startActivity(intent)
    }
}