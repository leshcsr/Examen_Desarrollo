package com.example.kotlin.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Obtén una referencia al botón
        val btnBackToFirst3to1 = findViewById<Button>(R.id.btnBackToFirst3to1)

        // Agrega un listener al botón para manejar el clic
        btnBackToFirst3to1.setOnClickListener {
            // Crea un intent para regresar a la primera vista
            val intent = Intent(this, Vista1Activity::class.java)
            startActivity(intent)
        }
    }
}