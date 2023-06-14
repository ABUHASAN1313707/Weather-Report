package com.example.weatherdata


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherdata.Adapter.WeatherAdapter
import com.example.weatherdata.Model.Report
import com.example.weatherdata.Network.Retrofit
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers




class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherAdapter= WeatherAdapter(this, ArrayList<Report>())
        recyclerView=findViewById(R.id.rv)
        recyclerView.apply {

            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=weatherAdapter
        }

        val compositeDisposal = CompositeDisposable()
        compositeDisposal.add(getObservable().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->getObserver(response as ArrayList<Report>)},
                { t -> onFailure(t)}))

    }


  private  fun getObservable(): Observable<List<Report>> {
        return  Retrofit.api.getAllData()


    }

    private  fun getObserver(weatheList: java.util.ArrayList<Report>){

        if(weatheList != null && weatheList.size>0){

            Log.e("size"," "+weatheList.size)
            weatherAdapter.setData(weatheList)

        }
    }

    private fun onFailure(t:Throwable){
        Toast.makeText(applicationContext,"$t",Toast.LENGTH_LONG).show()

    }

}