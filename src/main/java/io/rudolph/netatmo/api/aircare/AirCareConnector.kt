package io.rudolph.netatmo.api.aircare

import io.rudolph.netatmo.api.aircare.model.AirCareBody
import io.rudolph.netatmo.api.aircare.service.AirCareService
import io.rudolph.netatmo.api.common.CommonConnector
import io.rudolph.netatmo.executable
import io.rudolph.netatmo.executable.BodyResultExecutable
import retrofit2.Retrofit

class AirCareConnector(api: Retrofit) : CommonConnector(api) {

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
    fun Gethomecoachsdata(deviceId: String): BodyResultExecutable<AirCareBody> {
        return airCareService.getPublicData(
                "Empty",
                deviceId// will be replaced in Chain.proceed(accessToken: String)
        ).executable
    }

}