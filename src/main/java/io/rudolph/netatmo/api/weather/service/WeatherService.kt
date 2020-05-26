package io.rudolph.netatmo.api.weather.service

import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Forecast
import io.rudolph.netatmo.api.weather.model.ForecastRequestBody
import io.rudolph.netatmo.api.weather.model.Station
import retrofit2.http.*


internal interface WeatherService {

    @Headers("Content-Type:text/plain")
    @GET("getpublicdata")
    suspend fun getPublicData(
            @Query("lat_ne") latitudeNorthEast: Float,
            @Query("lon_ne") longitudeNorthEast: Float,
            @Query("lat_sw") latitudeSouthWest: Float,
            @Query("lon_sw") longitudeSouthWest: Float,
            @Query("required_data") requried: String? = null,
            @Query("filter") filter: Boolean? = null
    ): TypedBaseResult<List<Station>>

    @Headers("Content-Type:text/plain")
    @GET("getstationsdata")
    suspend fun getStationsData(
            @Query("device_id") deviceId: String? = null,
            @Query("get_favorites") getFavorites: Boolean? = null
    ): TypedBaseResult<StationResults>

    @Headers(value = ["User-Agent: NetatmoApp(Netatmo/v2.4.5.4/3204504) Android(5.0.2/unknown/Android SDK built for x86_64)",
        "Content-Type:application/json"])
    @POST("simplifiedfuturemeasure")
    suspend fun getSimpleForecast(@Body forecastBody: ForecastRequestBody): TypedBaseResult<Forecast>
}