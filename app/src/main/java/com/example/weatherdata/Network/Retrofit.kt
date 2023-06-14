package com.example.weatherdata.Network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class Retrofit {


    companion object {

      private  val retrofit =Retrofit.Builder()
            .baseUrl("https://weatherapi-com.p.rapidapi.com/")
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build()

        val api:Api = retrofit.create(Api::class.java)
    }
}