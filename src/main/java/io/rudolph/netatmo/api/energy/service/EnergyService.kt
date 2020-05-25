package io.rudolph.netatmo.api.energy.service

import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.energy.model.*
import retrofit2.http.*

@JvmSuppressWildcards
internal interface EnergyService {

    @POST("createnewhomeschedule")
    suspend fun createNewHomeSchedule(
            @Body body: CreateNewHomeScheduleBody
    ): TypedBaseResult<CreateNewHomeScheduleResponse>

    @Headers("Content-Type:text/plain")
    @POST("deletehomeschedule")
    suspend fun deleteHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @GET("homesdata")
    suspend fun getHomeData(
            @Query("home_id") homeId: String? = null,
            @Query("gateway_types") gatewayTypes: List<DeviceType>? = null
    ): TypedBaseResult<HomesDataBody>

    @Headers("Content-Type:text/plain")
    @GET("homestatus")
    suspend fun getHomeStatus(
            @Query("home_id") homeId: String,
            @Query("device_types") deviceTypes: List<DeviceType>? = null
    ): TypedBaseResult<HomeStatusBody>

    @Headers("Content-Type:text/plain")
    @GET("getroommeasure")
    suspend fun getRoomMeasure(
            @Query("home_id") homeId: String,
            @Query("room_id") roomId: String,
            @Query("scale") scale: String,
            @Query("type") temperatureType: TemperatureType = TemperatureType.TEMPERATURE,
            @Query("date_begin") dateBegin: Long? = null,
            @Query("date_end") dateEnd: Long? = null,
            @Query("limit") limit: Int? = null,
            @Query("optimize") optimize: Boolean = false,
            @Query("real_time") realTime: Boolean = false
    ): TypedBaseResult<RoomMeasureBody>

    @Headers("Content-Type:text/plain")
    @POST("renamehomeschedule")
    suspend fun postRenameHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("name") name: String,
            @Query("home_id") homeId: String
    ): BaseResult

    @POST("synchomeschedule")
    suspend fun setSyncHomeSchedule(
            @Body body: SetHomeScheduleBody
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("setthermmode")
    suspend fun setThermMode(
            @Query("home_id") homeId: String,
            @Query("mode") mode: Mode,
            @Query("endtime") endtime: Long?,
            @Query("schedule_id") scheduleId: String?
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("setroomthermpoint")
    suspend fun setRoomThermPoint(
            @Query("home_id") homeId: String,
            @Query("room_id") roomId: String,
            @Query("mode") mode: ThermPointMode,
            @Query("temp") temp: Float? = null,
            @Query("endtime") endtime: Long? = null
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("switchhomeschedule")
    suspend fun setSwitchHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): BaseResult
}
