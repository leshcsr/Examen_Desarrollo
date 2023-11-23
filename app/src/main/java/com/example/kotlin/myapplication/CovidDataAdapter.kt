// CovidDataAdapter.kt
package com.example.kotlin.myapplication
import com.example.kotlin.myapplication.CovidDataAdapter.ItemClickListener

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class CovidDataAdapter(private val covidDataList: List<CovidData>,
                       private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<CovidDataAdapter.CovidDataViewHolder>() {

    inner class CovidDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryTextView: TextView = itemView.findViewById(R.id.countryTextView)
        val casesTextView: TextView = itemView.findViewById(R.id.casesTextView)
        val deathsTextView: TextView = itemView.findViewById(R.id.deathsTextView)
        val recoveredTextView: TextView = itemView.findViewById(R.id.recoveredTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidDataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_second, parent, false)
        return CovidDataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CovidDataViewHolder, position: Int) {
        val currentData = covidDataList[position]

        holder.countryTextView.text = "Country: ${currentData.country}"
        holder.casesTextView.text = "Cases: ${currentData.cases}"
        holder.deathsTextView.text = "Deaths: ${currentData.deaths}"
        holder.recoveredTextView.text = "Recovered: ${currentData.recovered}"

        // Configurar el clic del elemento de la lista
        holder.itemView.setOnClickListener {
            ItemClickListener.onItemClick(currentData)
        }
    }


    override fun getItemCount(): Int {
        return covidDataList.size
    }

    interface ItemClickListener {
        fun onItemClick(covidData: CovidData)

        companion object
    }


}

private fun CovidDataAdapter.ItemClickListener.Companion.onItemClick(covidData: CovidData) {

}


