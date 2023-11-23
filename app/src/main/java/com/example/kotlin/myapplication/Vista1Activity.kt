package com.example.kotlin.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.kotlin.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class Vista1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el listener para el BottomNavigationView
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_second -> {
                    val intent = Intent(this@Vista1Activity, SecondActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_third -> {
                    val intent = Intent(this@Vista1Activity, ThirdActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    // Método para manejar el clic del botón para ir a SecondActivity
    fun goToSecondActivity(view: View) {
        val intent = Intent(this@Vista1Activity, SecondActivity::class.java)
        startActivity(intent)
    }
}