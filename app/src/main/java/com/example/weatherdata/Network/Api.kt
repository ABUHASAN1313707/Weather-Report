package com.example.weatherdata.Network

//import android.database.Observable

import com.example.weatherdata.Model.Report
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {

    @Headers(
        "X-RapidAPI-Key: ff39a44c01mshf39c88386b7f73ap1281f6jsna40111c8b89b",
        "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com"
    )
    @GET(value = "forecast.json?q=London&days=3")
    fun getAllData():Observable<List<Report>>

}