package com.example.weatherdata.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.weatherdata.Model.Report
import com.example.weatherdata.R
import org.w3c.dom.Text
import java.util.ArrayList

class WeatherAdapter(private var context:Context,private var weatherList: ArrayList<Report> ) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {

        return WeatherViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun getItemCount(): Int = weatherList.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {

        val weather = weatherList[position]
        holder.name.text=weather.name
        holder.maxtemp_c.text= weather.maxtemp_c.toDouble().toString()
        holder.wind_kph.text= weather.wind_kph.toDouble().toString()
        holder.humidity.text=weather.humidity.toString()
    }

    fun setData(weatherList: ArrayList<Report>){

        this.weatherList=weatherList
        notifyDataSetChanged()
    }



    inner class WeatherViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        val name:TextView= itemView.findViewById(R.id.name)
        val maxtemp_c:TextView= itemView.findViewById(R.id.maxtemp_c)
        val wind_kph:TextView= itemView.findViewById(R.id.wind_kph)
        val humidity:TextView= itemView.findViewById(R.id.humidity)
    }
}