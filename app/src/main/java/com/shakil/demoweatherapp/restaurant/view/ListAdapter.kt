package com.shakil.demoweatherapp.restaurant.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shakil.demoweatherapp.R
import com.shakil.demoweatherapp.restaurant.loadImg
import com.shakil.demoweatherapp.restaurant.model.HotelModel
import kotlinx.android.synthetic.main.item_feed.view.*

class ListAdapter(val data: List<HotelModel>) : RecyclerView.Adapter<ListAdapter.HotelHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ListAdapter.HotelHolder {
        return HotelHolder.create(p0)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ListAdapter.HotelHolder, p1: Int) {
        p0.bind(data[p1])
    }

    class HotelHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun bind(hotelModel : HotelModel) {
            itemView.rootView.imageView.loadImg(hotelModel.photo)
            itemView.rootView.name.text = hotelModel.name
            itemView.rootView.rating.text = hotelModel.rating
            itemView.rootView.ratingBar.rating = hotelModel.rating.toFloat()



        }

        companion object {

            fun create(parent: ViewGroup): HotelHolder {
                val view = LayoutInflater.from(parent.context).inflate(CONTENT_ITEM_ID, parent, false)
                return HotelHolder(view)
            }
        }
    }

    companion object {

        const val CONTENT_ITEM_ID = R.layout.item_feed
    }



}