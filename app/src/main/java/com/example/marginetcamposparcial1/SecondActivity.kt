package com.example.marginetcamposparcial1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var listView: ListView
    private lateinit var nacionalidad: String
    private val IntentGetter = IntentGetter()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        spinner = findViewById(R.id.spinnerPaises)
        listView = findViewById(R.id.lwDeportistas)

        val deportistas = mutableListOf("")

        val data = intent.extras
        val pais1 = data?.getString("pais1")
        val pais2 = data?.getString("pais2")
        val pais3 = data?.getString("pais3")

        val paises = listOf(pais1, pais2, pais3)

        val deportistasAr = listOf(
            Deportista(1,"Lionel Messi","Futbol","Argentina","Si"),
            Deportista(2,"Ariel Ortega","Futbol","Argentina","No"),
            Deportista(3,"Angel Di Maria","Futbol","Argentina","Si"),
            Deportista(4,"Julian Alvarez","Futbol","Argentina","Si"),
            Deportista(5,"Emanuel Ginobili","Baloncesto","Argentina","No"),
            Deportista(6,"Juan Martin del Potro","Tennis","Argentina","No"),
            Deportista(7,"Luis Scola","Baloncesto","Argentina","No"),
            Deportista(8,"Luciana Aymar","Hockey","Argentina","No"),
            Deportista(9,"Agustin Pichot","Rugby","Argentina","No"),
            Deportista(10,"Paula Pareto","Judo","Argentina","No"),
        )
        val nombresAr = deportistasAr.map {it.nombre}

        val deportistasUr = listOf(
            Deportista(11,"Enzo Francescoli","Futbol","Uruguay","No"),
            Deportista(12,"Luis Suarez","Futbol","Uruguay","Si"),
            Deportista(13,"Edinson Cavani","Futbol","Uruguay","Si"),
            Deportista(14,"Diego Forlan","Futbol","Uruguay","No"),
            Deportista(15,"Alfredo Evangelista","Boxeo","Uruguay","No"),
            Deportista(16,"Esteban Batista","Baloncesto ","Uruguay","No"),
            Deportista(17,"Diego Perez","Futbol","Uruguay","No"),
            Deportista(18,"Cecilia Comunales","Boxeo","Uruguay","Si"),
            Deportista(19,"Gonzalo Rodriguez","Automovilismo","Uruguay","No"),
            Deportista(20,"Rodrigo Bentancur","Futbol","Uruguay","Si")
        )
        val nombresUr = deportistasUr.map {it.nombre}

        val deportistasBr = listOf(
            Deportista(21,"Ronaldinho","Futbol","Brazil","No"),
            Deportista(22,"Pelé","Futbol","Brazil","No"),
            Deportista(23,"Neymar Jr","Futbol","Brazil","Si"),
            Deportista(24,"Zico","Futbol","Brazil","No"),
            Deportista(25,"Ayrton Senna","Automovilismo","Brazil","No"),
            Deportista(26,"Ronaldo Nazario","Futbol","Brazil","No"),
            Deportista(27,"Gustavo Kuerten","Tennis","Brazil","No"),
            Deportista(28,"Roberto Carlos","Futbol","Brazil","No"),
            Deportista(29,"Oscar Schmidt","Baloncesto","Brazil","No"),
            Deportista(30,"Rebeca Andrade","Gimnasta","Brazil","Si")
        )
        val nombresBr = deportistasBr.map {it.nombre}

        val adapterPaises = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, paises)
        val adapterDeportistas = ArrayAdapter(this, android.R.layout.simple_list_item_1, deportistas)

        spinner.adapter = adapterPaises
        listView.adapter = adapterDeportistas

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val nacionalidad = paises[position]
                when (nacionalidad) {
                    "Argentina" -> {
                        deportistas.clear()
                        deportistas.addAll(nombresAr)
                        adapterDeportistas.notifyDataSetChanged()
                    }
                    "Uruguay" -> {
                        deportistas.clear()
                        deportistas.addAll(nombresUr)
                        adapterDeportistas.notifyDataSetChanged()
                    }
                    "Brazil" -> {
                        deportistas.clear()
                        deportistas.addAll(nombresBr)
                        adapterDeportistas.notifyDataSetChanged()
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            nacionalidad = spinner.selectedItem.toString()
            val deportistaSeleccionado = when (nacionalidad) {
                "Argentina" -> deportistasAr[position]
                "Uruguay" -> deportistasUr[position]
                "Brazil" -> deportistasBr[position]
                else -> null
            }
            if (deportistaSeleccionado != null) {
                IntentGetter.getIntent(deportistaSeleccionado.nombre, deportistaSeleccionado.deporte, deportistaSeleccionado.actividad, this)
            }
        }
    }
}