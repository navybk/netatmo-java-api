package io.rudolph.netatmo.api.aircare

import io.rudolph.netatmo.api.aircare.model.AirCareBody
import io.rudolph.netatmo.api.aircare.service.AirCareService
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.executable.Executable
import retrofit2.Retrofit

class AirCareConnector(api: Retrofit) {
    private val airCareService = api.create(AirCareService::class.java)

    /**
     * Returns data from a user's Healthy Home Coach (measures and device specific data)
     *
     * required scope: read_homecoach
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/aircare/gethomecoachsdata)
     *
     * @param deviceId Healthy Home Coach mac address
     * @return an executable object to obtain the [AirCareBody]
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