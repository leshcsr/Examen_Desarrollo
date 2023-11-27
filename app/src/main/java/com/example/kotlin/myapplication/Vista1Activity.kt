package com.example.kotlin.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Actividad principal de la aplicación que muestra datos relacionados con COVID-19.
 */
class Vista1Activity : AppCompatActivity() {

    /**
     * Método llamado al crear la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializeBinding()
        getCovidData()

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

    /**
     * Apartir de aquí es la nueva version
     *
     * */
    private fun getCovidData(){
        CoroutineScope(Dispatchers.IO).launch {
            val covidRepository = CovidRepository()
            val result: CovidDataResponse? = covidRepository.getCovidData("Canada", "Alberta")
            Log.d("CovidData", result.toString() )

        }
    }


}





