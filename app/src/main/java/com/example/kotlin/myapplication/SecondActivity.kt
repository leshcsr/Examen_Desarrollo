package com.example.kotlin.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Obtén una referencia al botón
        val btnBackToFirst = findViewById<Button>(R.id.btnBackToFirst)

        // Agrega un listener al botón para manejar el clic
        btnBackToFirst.setOnClickListener {
            // Crea un intent para regresar a la primera vista
            val intent = Intent(this, Vista1Activity::class.java)
            startActivity(intent)
        }
    }
}