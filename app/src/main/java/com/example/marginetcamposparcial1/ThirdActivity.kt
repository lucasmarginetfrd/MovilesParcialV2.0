package com.example.marginetcamposparcial1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var textViewNombre: TextView
    private lateinit var textViewDeporte: TextView
    private lateinit var textViewActividad: TextView
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        textViewNombre = findViewById(R.id.tvNombre)
        textViewDeporte = findViewById(R.id.tvDeporte)
        textViewActividad = findViewById(R.id.tvActividad)

        val bundle = intent.extras

        val nom = bundle?.getString("nombre")
        val dep = bundle?.getString("deporte")
        val act = bundle?.getString("actividad")

        textViewNombre.text = nom
        textViewDeporte.text = dep
        textViewActividad.text = act

        button = findViewById(R.id.button)
        button.setOnClickListener {
            finish()
        }

    }
}
