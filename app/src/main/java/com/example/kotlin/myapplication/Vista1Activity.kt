package com.example.kotlin.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        // Iniciar la llamada a la API
        fetchDataFromApi()

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
     * Método para realizar una llamada a la API y obtener datos relacionados con COVID-19.
     */
    private fun fetchDataFromApi() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://covid-api.mmediagroup.fr/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(CovidApiService::class.java)

        // Utilizar un CoroutineScope para llamar a la API de manera asíncrona
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getCovidData("wLVPN1zV08lJYF7uXqgyPw==zVwp6TlVcAO1NLUf")

                // Actualizar la interfaz de usuario en el hilo principal
                withContext(Dispatchers.Main) {
                    updateUI(response)
                }
            } catch (e: Exception) {
                // Manejar errores, por ejemplo, mostrar un mensaje de error
            }
        }
    }

    /**
     * Método para actualizar la interfaz de usuario con los datos obtenidos de la API.
     */
    private fun updateUI(covidDataList: List<CovidData>) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = CovidDataAdapter(covidDataList, object : CovidDataAdapter.ItemClickListener {
            override fun onItemClick(covidData: CovidData) {
                // Manejar el clic del elemento de la lista
                val intent = Intent(this@Vista1Activity, SecondActivity::class.java)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
