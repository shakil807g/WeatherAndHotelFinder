package com.shakil.demoweatherapp.restaurant.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.shakil.demoweatherapp.R
import com.shakil.demoweatherapp.restaurant.controller.LocationServices
import com.shakil.demoweatherapp.restaurant.controller.Server
import com.shakil.demoweatherapp.restaurant.model.NearbyModel
import com.shakil.demoweatherapp.weather.view.activities.BaseActivity
import kotlinx.android.synthetic.main.activity_restaurant.*

class RestaurantListActivity: BaseActivity(){

    var adapter: ListAdapter? = null
    var layoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        back.setOnClickListener {
            finish()
        }


        main_swipe_refresh_layout.isEnabled = true
        main_swipe_refresh_layout.isRefreshing = true

        LocationServices(this){ location, error ->
            if(error == null && location != null){
                Server().requestNearbyRestaurantData(location){ ServerResult,ServerError ->
                    if(ServerError != null){
                        main_swipe_refresh_layout.isEnabled = false
                        main_swipe_refresh_layout.isRefreshing = false
                        Toast.makeText(this,ServerError,Toast.LENGTH_LONG).show()
                    }else{
                        main_swipe_refresh_layout.isEnabled = false
                        main_swipe_refresh_layout.isRefreshing = false
                        initList(ServerResult)
                    }
                }
            }else{
                main_swipe_refresh_layout.isEnabled = false
                main_swipe_refresh_layout.isRefreshing = false
                Toast.makeText(this,error,Toast.LENGTH_LONG).show()
            }

        }.apply { locationPermission() }


    }

    private fun initList(serverResult: NearbyModel?) {
        layoutManager =  LinearLayoutManager(this)
        adapter = ListAdapter(serverResult?.toHotelModel()!!)
        list.adapter = adapter
        list.setHasFixedSize(true)
        list.layoutManager = layoutManager

    }

}