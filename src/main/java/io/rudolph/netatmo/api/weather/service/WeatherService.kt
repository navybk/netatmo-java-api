package io.rudolph.netatmo.api.weather.service

import io.rudolph.netatmo.api.aircare.model.AirCareBody
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Station
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


internal interface WeatherService {

    @Headers("Content-Type:text/plain")
    @GET("getpublicdata")
    fun getPublicData(
            @Query("access_token") accessToken: String,
            @Query("lat_ne") latitudeNorthEast: Float,
            @Query("lon_ne") longitudeNorthEast: Float,
            @Query("lat_sw") latitudeSouthWest: Float,
            @Query("lon_sw") longitudeSouthWest: Float,
            @Query("required_data") requried: String? = null,
            @Query("filter") filter: Boolean? = null
    ): Call<TypedBaseResult<List<Station>>>

    @Headers("Content-Type:text/plain")
    @POST("getpublicdata")
    fun getPublicDataPost(
            @Query("access_token") accessToken: String,
            @Query("lat_ne") latitudeNorthEast: Float,
            @Query("lon_ne") longitudeNorthEast: Float,
            @Query("lat_sw") latitudeSouthWest: Float,
            @Query("lon_sw") longitudeSouthWest: Float,
            @Query("required_data") requried: String? = null,
            @Query("filter") filter: Boolean? = null
    ): Call<TypedBaseResult<List<Station>>>

    @Headers("Content-Type:text/plain")
    @GET("getstationsdata")
    fun getStationData(
            @Query("access_token") accessToken: String,
            @Query("device_id") deviceId: String? = null,
            @Query("get_favorites") getFavorites: Boolean? = null
    ): Call<TypedBaseResult<AirCareBody>>

    @Headers("Content-Type:text/plain")
    @POST("getstationsdata")
    fun getStationDataPost(
            @Query("access_token") accessToken: String,
            @Query("device_id") deviceId: String? = null,
            @Query("get_favorites") getFavorites: Boolean? = null
    ): Call<TypedBaseResult<AirCareBody>>
}