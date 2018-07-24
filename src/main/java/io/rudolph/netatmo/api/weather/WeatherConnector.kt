package io.rudolph.netatmo.api.weather

import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.weather.model.Station
import io.rudolph.netatmo.api.weather.service.WeatherService
import io.rudolph.netatmo.executable.Executable
import retrofit2.Retrofit

class WeatherConnector(api: Retrofit) {
    private val weatherService = api.create(WeatherService::class.java)

    fun getPublicData(latitudeNorthEast: Float,
                      longitudeNorthEast: Float,
                      latitudeSouthWest: Float,
                      longitudeSouthWest: Float,
                      requried: String? = null,
                      filter: Boolean? = null): Executable<TypedBaseResult<List<Station>>> {
        return weatherService.getPublicData(
                "Empty",
                latitudeNorthEast,
                longitudeNorthEast,
                latitudeSouthWest,
                longitudeSouthWest,
                requried,
                filter)
                .let {
                    Executable(it)
                }
    }

}