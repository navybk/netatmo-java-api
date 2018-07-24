package io.rudolph.netatmo.api.aircare

import io.rudolph.netatmo.api.aircare.model.AirCareBody
import io.rudolph.netatmo.api.aircare.service.AirCareService
import io.rudolph.netatmo.api.energy.model.HomesDataBody
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.executable.Executable
import retrofit2.Retrofit

class AirCareConnector(api: Retrofit) {
    private val airCareService = api.create(AirCareService::class.java)

    /**
     * Retrieves publicly shared weather data from Outdoor Modules within a predefined area.
     *
     * required scope: none required
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/weatherapi/getpublicdata)
     *
     * @param deviceId latitude of the north east corner of the requested area. -85 <= lat_ne <= 85 and lat_ne>lat_sw
     * @return an executable object to obtain the [HomesDataBody]
     */
    fun Gethomecoachsdata(deviceId: String): Executable<TypedBaseResult<AirCareBody>> {
        return airCareService.getPublicData(
                "Empty",
                deviceId// will be replaced in Chain.proceed(accessToken: String)
                )
                .let {
                    Executable(it)
                }
    }

}