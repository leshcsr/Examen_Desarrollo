// CovidDataAdapter.kt
package com.example.kotlin.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CovidDataAdapter(
    private val covidDataList: List<CovidData>,
    private val itemClickListener: ItemClickListener
) : RecyclerView.Adapter<CovidDataAdapter.CovidDataViewHolder>() {

    // Clase interna que representa el ViewHolder para cada elemento de la lista
    inner class CovidDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referencias a las vistas en el diseño de cada elemento
        val countryTextView: TextView = itemView.findViewById(R.id.countryTextView)
        val casesTextView: TextView = itemView.findViewById(R.id.casesTextView)
        val deathsTextView: TextView = itemView.findViewById(R.id.deathsTextView)
        val recoveredTextView: TextView = itemView.findViewById(R.id.recoveredTextView)
    }

    // Crea y devuelve un ViewHolder para cada elemento de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidDataViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_second, parent, false)
        return CovidDataViewHolder(itemView)
    }

    // Vincula los datos en cada posición con las vistas correspondientes
    override fun onBindViewHolder(holder: CovidDataViewHolder, position: Int) {
        val currentData = covidDataList[position]

        // Configurar el texto de cada vista con los datos correspondientes
        holder.countryTextView.text = "Country: ${currentData.country}"
        holder.casesTextView.text = "Cases: ${currentData.cases}"
        holder.deathsTextView.text = "Deaths: ${currentData.deaths}"
        holder.recoveredTextView.text = "Recovered: ${currentData.recovered}"

        // Configurar el clic del elemento de la lista
        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(currentData)
        }
    }

    // Devuelve el número total de elementos en la lista
    override fun getItemCount(): Int {
        return covidDataList.size
    }

    // Interfaz para manejar eventos de clic en elementos de la lista
    interface ItemClickListener {
        fun onItemClick(covidData: CovidData)
    }
}


