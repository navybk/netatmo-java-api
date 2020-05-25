package io.rudolph.netatmo.api.aircare.service

import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

internal interface AirCareService {
    @Headers("Content-Type:text/plain")
    @GET("gethomecoachsdata")
    suspend fun getHomeCoachsData(
            @Query("access_token") accessToken: String,
            @Query("device_id") deviceId: String? = null
    ): TypedBaseResult<StationResults>
}