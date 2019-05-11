package com.shakil.demoweatherapp.restaurant

import android.widget.ImageView
import com.shakil.demoweatherapp.R
import com.squareup.picasso.Picasso


val baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?"
val basePlaceDetailUrl = "https://maps.googleapis.com/maps/api/place/details/json?"
val key = "AIzaSyB_SGF4nGa56t9NnqtZ1kixeVnhQuEfaCY"


fun ImageView.loadImg(imageUrl: String?, placeHolder: Int = R.drawable.img_placeholder) {
    if (imageUrl != null && imageUrl.trim().isEmpty()) {
        setImageResource(placeHolder)
    } else {
        Picasso.get().load(imageUrl)
            .placeholder(placeHolder)
            .centerCrop()
            .fit().into(this)
    }
}