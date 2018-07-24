package io.rudolph.netatmo.api.common.service

import io.rudolph.netatmo.api.common.model.MeasureRequestResponse
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CommonService {

    @Headers("Content-Type:text/plain")
    @GET("getmeasure")
    fun getMeasure(
            @Query("access_token") accessToken: String,
            @Query("device_id") deviceId: String,
            @Query("module_id") moduleId: String,
            @Query("scale") scale: String,
            @Query("type") type: String,
            @Query("date_begin") dateBegin: Long? = null,
            @Query("date_end") dateEnd: Long? = null,
            @Query("limit") limit: Int? = null,
            @Query("optimize") optimize: Boolean? = null,
            @Query("real_time") realTime: String? = null
            ): Call<TypedBaseResult<List<MeasureRequestResponse>>>
}