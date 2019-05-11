package com.shakil.demoweatherapp.restaurant.controller

import android.util.Log
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import com.shakil.demoweatherapp.restaurant.basePlaceDetailUrl
import com.shakil.demoweatherapp.restaurant.baseUrl
import com.shakil.demoweatherapp.restaurant.key
import com.shakil.demoweatherapp.restaurant.model.NearbyModel
import com.shakil.demoweatherapp.weather.model.TAG_C_SERVER
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

/**
 * Created by shakil.
 */
class Server {

    //apiService.doPlaces("restaurant", latLngString, businessName, true, "distance", APIClient.GOOGLE_PLACE_API_KEY);



    //https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=1500
    // &type=restaurant&keyword=cruise&key=AIzaSyDYsKes3MvaN44B4VMxI3MgZ5PlKHefqm0

     fun requestNearbyRestaurantData(location: String,result: (data: NearbyModel?,error: String?)-> Unit) {
         val link = "${baseUrl}location=$location&radius=1500&type=restaurant&key=${key}"
         val client = AsyncHttpClient()
        client.get(link, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                if (response != null) {
                    val nearByModel = Gson().fromJson(response.toString(), NearbyModel::class.java)
                    result(nearByModel,null)
                }
                Log.d(TAG_C_SERVER, "requestForecastData() onSuccess response: ${response.toString()}.")
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                Log.e(TAG_C_SERVER, "requestForecastData() onFailure() ${throwable.toString()}.")
                Log.d(TAG_C_SERVER, "requestForecastData() statusCode: $statusCode.")

            }
        })
    }


    fun requestPlaceDetailsData(location: String,result: (data: NearbyModel?,error: String?)-> Unit) {

        val link = "${basePlaceDetailUrl}placeid=$location&radius=1500&type=restaurant&key=${key}"

        val client = AsyncHttpClient()

        client.get(link, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                if (response != null) {
                    val nearByModel = Gson().fromJson(response.toString(), NearbyModel::class.java)
                    result(nearByModel,null)
                }
                Log.d(TAG_C_SERVER, "requestForecastData() onSuccess response: ${response.toString()}.")
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                Log.e(TAG_C_SERVER, "requestForecastData() onFailure() ${throwable.toString()}.")
                Log.d(TAG_C_SERVER, "requestForecastData() statusCode: $statusCode.")

            }
        })
    }


}