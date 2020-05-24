package io.rudolph.netatmo.api.energy.service

import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.energy.model.*
import retrofit2.http.*

internal interface EnergyService {
    @Headers("Content-Type:text/plain")
    @GET("createnewhomeschedule")
    suspend fun createNewHomeScheduleGet(
            @Body body: CreateNewHomeScheduleBody
    ): TypedBaseResult<CreateNewHomeScheduleResponse>

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
    @GET("deletehomeschedule")
    suspend fun deleteHomeScheduleGet(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @GET("homesdata")
    suspend fun getHomeData(
            @Query("home_id") homeId: String? = null,
            @Query("gateway_types") gatewayTypes: MutableList<DeviceType>? = null
    ): TypedBaseResult<HomesDataBody>

    @Headers("Content-Type:text/plain")
    @POST("homesdata")
    suspend fun getHomeDataPost(
            @Query("home_id") homeId: String,
            @Query("gateway_types") gatewayTypes: MutableList<DeviceType>? = null
    ): TypedBaseResult<HomesDataBody>

    @Headers("Content-Type:text/plain")
    @GET("homestatus")
    suspend fun getHomeStatus(
            @Query("home_id") homeId: String,
            @Query("device_types") deviceTypes: MutableList<DeviceType>? = null
    ): TypedBaseResult<HomeStatusBody>

    @Headers("Content-Type:text/plain")
    @POST("homestatus")
    suspend fun getHomeStatusPost(
            @Query("home_id") homeId: String,
            @Query("device_types") deviceTypes: MutableList<DeviceType>? = null
    ): TypedBaseResult<HomeStatusBody>

    @Headers("Content-Type:text/plain")
    @GET("renamehomeschedule")
    suspend fun getRenameHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("name") name: String,
            @Query("home_id") homeId: String
    ): BaseResult

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
    @POST("getroommeasure")
    suspend fun getRoomMeasurePost(
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
    @GET("synchomeschedule")
    suspend fun setSyncHomeScheduleGet(
            @Body body: Body
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("setroomthermmode")
    suspend fun setRoomThermMode(
            @Query("home_id") homeId: String,
            @Query("mode") mode: Mode,
            @Query("endtime") endtime: Long?
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @GET("setroomthermmode")
    suspend fun setRoomThermModeGet(
            @Query("home_id") homeId: String,
            @Query("mode") mode: Mode,
            @Query("endtime") endtime: Long?
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
    @GET("setroomthermpoint")
    suspend fun setRoomThermPointGet(
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

    @Headers("Content-Type:text/plain")
    @GET("switchhomeschedule")
    suspend fun setSwitchHomeScheduleGet(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): BaseResult

}
