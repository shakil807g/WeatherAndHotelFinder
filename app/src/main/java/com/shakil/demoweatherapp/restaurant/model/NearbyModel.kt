package com.shakil.demoweatherapp.restaurant.model
import com.google.gson.annotations.SerializedName


data class NearbyModel(
    @SerializedName("html_attributions")
    var htmlAttributions: List<Any?>?,
    @SerializedName("results")
    var results: List<Result?>?,
    @SerializedName("status")
    var status: String?
)

data class Result(
    @SerializedName("geometry")
    var geometry: Geometry?,
    @SerializedName("icon")
    var icon: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("opening_hours")
    var openingHours: OpeningHours?,
    @SerializedName("photos")
    var photos: List<Photo?>?,
    @SerializedName("place_id")
    var placeId: String?,
    @SerializedName("plus_code")
    var plusCode: PlusCode?,
    @SerializedName("price_level")
    var priceLevel: Int?,
    @SerializedName("rating")
    var rating: Double?,
    @SerializedName("reference")
    var reference: String?,
    @SerializedName("scope")
    var scope: String?,
    @SerializedName("types")
    var types: List<String?>?,
    @SerializedName("user_ratings_total")
    var userRatingsTotal: Int?,
    @SerializedName("vicinity")
    var vicinity: String?
)

data class PlusCode(
    @SerializedName("compound_code")
    var compoundCode: String?,
    @SerializedName("global_code")
    var globalCode: String?
)

data class OpeningHours(
    @SerializedName("open_now")
    var openNow: Boolean?
)

data class Photo(
    @SerializedName("height")
    var height: Int?,
    @SerializedName("html_attributions")
    var htmlAttributions: List<String?>?,
    @SerializedName("photo_reference")
    var photoReference: String?,
    @SerializedName("width")
    var width: Int?
)

data class Geometry(
    @SerializedName("location")
    var location: Location?,
    @SerializedName("viewport")
    var viewport: Viewport?
)

data class Viewport(
    @SerializedName("northeast")
    var northeast: Northeast?,
    @SerializedName("southwest")
    var southwest: Southwest?
)

data class Northeast(
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lng")
    var lng: Double?
)

data class Southwest(
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lng")
    var lng: Double?
)

data class Location(
    @SerializedName("lat")
    var lat: Double?,
    @SerializedName("lng")
    var lng: Double?
)