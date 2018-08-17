package io.rudolph.netatmo.api.weather.service

import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Forecast
import io.rudolph.netatmo.api.weather.model.ForecastRequestBody
import io.rudolph.netatmo.api.weather.model.Station
import retrofit2.Call
import retrofit2.http.*


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
    ): Call<TypedBaseResult<StationResults>>

    @Headers("Content-Type:text/plain")
    @POST("getstationsdata")
    fun getStationDataPost(
            @Query("access_token") accessToken: String,
            @Query("device_id") deviceId: String? = null,
            @Query("get_favorites") getFavorites: Boolean? = null
    ): Call<TypedBaseResult<StationResults>>

    @Headers(value = ["User-Agent: NetatmoApp(Netatmo/v2.4.5.4/3204504) Android(5.0.2/unknown/Android SDK built for x86_64)",
        "Content-Type:application/json"])
    @POST("simplifiedfuturemeasure")
    fun getSimpleForecast(@Body forecastBody: ForecastRequestBody): Call<TypedBaseResult<Forecast>>


}