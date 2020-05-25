package io.rudolph.netatmo.api.common.service

import io.rudolph.netatmo.api.common.model.MeasureRequestResponse
import io.rudolph.netatmo.api.common.model.Scale
import io.rudolph.netatmo.api.common.model.ScaleType
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

@JvmSuppressWildcards
internal interface CommonService {

    @Headers("Content-Type:text/plain")
    @GET("getmeasure")
    suspend fun getMeasure(
            @Query("access_token") accessToken: String,
            @Query("device_id") deviceId: String,
            @Query("module_id") moduleId: String,
            @Query("scale") scales: List<Scale>,
            @Query("type") types: List<ScaleType>,
            @Query("date_begin") dateBegin: Long? = null,
            @Query("date_end") dateEnd: Long? = null,
            @Query("limit") limit: Int? = null,
            @Query("optimize") optimize: Boolean? = null,
            @Query("real_time") realTime: Boolean? = null
    ): TypedBaseResult<List<MeasureRequestResponse>>
}