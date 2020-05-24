package io.rudolph.netatmo.api.weather

import io.rudolph.netatmo.api.common.CommonConnector
import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.weather.model.Forecast
import io.rudolph.netatmo.api.weather.model.ForecastRequestBody
import io.rudolph.netatmo.api.weather.model.Station
import io.rudolph.netatmo.api.weather.service.WeatherService
import io.rudolph.netatmo.executable.BodyResultExecutable
import retrofit2.Retrofit

class WeatherConnector(api: Retrofit) : CommonConnector(api) {
    private val weatherService = api.create(WeatherService::class.java)

    /**
     * Retrieves publicly shared weatherApi data from Outdoor Modules within a predefined area.
     *
     * required scope: none required
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/weatherapi/getpublicdata)
     *
     * @param latitudeNorthEast latitude of the north east corner of the requested area. -85 <= lat_ne <= 85 and lat_ne>lat_sw
     * @param longitudeNorthEast Longitude of the north east corner of the requested area. -180 <= lon_ne <= 180 and lon_ne>lon_sw
     * @param latitudeSouthWest latitude of the south west corner of the requested area. -85 <= lat_sw <= 85
     * @param longitudeSouthWest Longitude of the south west corner of the requested area. -180 <= lon_sw <= 180
     * @param required To filter stations based on relevant measurements you want (e.g. rain will only return stations with rain gauges). Default is no filter. You can find all measurements available on the Thermostat page.
     * @param filter True to exclude station with abnormal temperature measures. Default is false.
     * @return an executable object to obtain the [Station]
     */
    fun getPublicData(latitudeNorthEast: Float,
                      longitudeNorthEast: Float,
                      latitudeSouthWest: Float,
                      longitudeSouthWest: Float,
                      required: String? = null,
                      filter: Boolean? = null): BodyResultExecutable<List<Station>> {
        return BodyResultExecutable {
            weatherService.getPublicData(
                    "Empty", // will be replaced in Chain.proceed(accessToken: String)
                    latitudeNorthEast,
                    longitudeNorthEast,
                    latitudeSouthWest,
                    longitudeSouthWest,
                    required,
                    filter)
        }
    }

    fun getSimpleForecast(deviceId: String, moduleId: String): BodyResultExecutable<Forecast> {
        val body = ForecastRequestBody(devideId = deviceId, moduleId = moduleId)
        return BodyResultExecutable {
            weatherService.getSimpleForecast(body)
        }
    }

    fun getStationData(deviceId: String? = null,
                       getFavourites: Boolean? = null): BodyResultExecutable<StationResults> {
        return BodyResultExecutable {
            weatherService.getStationData("Empty",
                    deviceId,
                    getFavourites)
        }
    }

}