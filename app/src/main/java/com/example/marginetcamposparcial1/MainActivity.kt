package com.example.marginetcamposparcial1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etpais1: EditText
    private lateinit var etpais2: EditText
    private lateinit var etpais3: EditText
    private lateinit var button: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etpais1 = findViewById(R.id.etPais1)
        etpais2 = findViewById(R.id.etPais2)
        etpais3 = findViewById(R.id.etPais3)
        button = findViewById(R.id.button)

        button.setOnClickListener{
            val pais1 = etpais1.text.toString()
            val pais2 = etpais2.text.toString()
            val pais3 = etpais3.text.toString()


            if (pais1.isNotBlank() && pais2.isNotBlank() && pais3.isNotBlank()) {
                intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("pais1", pais1)
                intent.putExtra("pais2", pais2)
                intent.putExtra("pais3", pais3)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Se necesitan los 3 paises", Toast.LENGTH_SHORT).show()
            }
        }

    }
}