package com.shakil.demoweatherapp.restaurant.view

import com.shakil.demoweatherapp.restaurant.key
import com.shakil.demoweatherapp.restaurant.model.HotelModel
import com.shakil.demoweatherapp.restaurant.model.NearbyModel

fun NearbyModel.toHotelModel(): List<HotelModel> {


     return results?.mapNotNull {
         HotelModel(name = it?.name ?: "",
             rating = "${it?.rating}",
             photo = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${it?.photos?.get(0)?.photoReference}&key=${key}")

     }!!

}