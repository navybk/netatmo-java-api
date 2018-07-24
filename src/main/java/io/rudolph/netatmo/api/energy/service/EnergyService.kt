package io.rudolph.netatmo.api.energy.service

import io.rudolph.netatmo.api.misc.model.DeviceType
import io.rudolph.netatmo.api.energy.model.*
import retrofit2.Call
import retrofit2.http.*

internal interface EnergyService {
    @Headers("Content-Type:text/plain")
    @GET("createnewhomeschedule")
    fun createNewHomeScheduleGet(
            @Body body: CreateNewHomeScheduleBody
    ): Call<TypedBaseResult<CreateNewHomeScheduleResponse>>

    @POST("createnewhomeschedule")
    fun createNewHomeSchedule(
            @Body body: CreateNewHomeScheduleBody
    ): Call<TypedBaseResult<CreateNewHomeScheduleResponse>>

    @Headers("Content-Type:text/plain")
    @POST("deletehomeschedule")
    fun deleteHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("deletehomeschedule")
    fun deleteHomeScheduleGet(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("homesdata")
    fun getHomeData(
            @Query("home_id") homeId: String? = null,
            @Query("gateway_types") gatewayTypes: MutableList<DeviceType>? = null
    ): Call<TypedBaseResult<HomesDataBody>>

    @Headers("Content-Type:text/plain")
    @POST("homesdata")
    fun getHomeDataPost(
            @Query("home_id") homeId: String,
            @Query("gateway_types") gatewayTypes: MutableList<DeviceType>? = null
    ): Call<TypedBaseResult<HomesDataBody>>

    @Headers("Content-Type:text/plain")
    @GET("homestatus")
    fun getHomeStatus(
            @Query("home_id") homeId: String,
            @Query("device_types") deviceTypes: MutableList<DeviceType>? = null
    ): Call<TypedBaseResult<HomeStatusBody>>

    @Headers("Content-Type:text/plain")
    @POST("homestatus")
    fun getHomeStatusPost(
            @Query("home_id") homeId: String,
            @Query("device_types") deviceTypes: MutableList<DeviceType>? = null
    ): Call<TypedBaseResult<HomeStatusBody>>

    @Headers("Content-Type:text/plain")
    @GET("renamehomeschedule")
    fun getRenameHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("name") name: String,
            @Query("home_id") homeId: String
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("getroommeasure")
    fun getRoomMeasure(
            @Query("home_id") homeId: String,
            @Query("room_id") roomId: String,
            @Query("scale") scale: String,
            @Query("type") temperatureType: TemperatureType = TemperatureType.TEMPERATURE,
            @Query("date_begin") dateBegin: Long? = null,
            @Query("date_end") dateEnd: Long? = null,
            @Query("limit") limit: Int? = null,
            @Query("optimize") optimize: Boolean = false,
            @Query("real_time") realTime: Boolean = false
    ): Call<TypedBaseResult<RoomMeasureBody>>

    @Headers("Content-Type:text/plain")
    @POST("getroommeasure")
    fun getRoomMeasurePost(
            @Query("home_id") homeId: String,
            @Query("room_id") roomId: String,
            @Query("scale") scale: String,
            @Query("type") temperatureType: TemperatureType = TemperatureType.TEMPERATURE,
            @Query("date_begin") dateBegin: Long? = null,
            @Query("date_end") dateEnd: Long? = null,
            @Query("limit") limit: Int? = null,
            @Query("optimize") optimize: Boolean = false,
            @Query("real_time") realTime: Boolean = false
    ): Call<TypedBaseResult<RoomMeasureBody>>

    @Headers("Content-Type:text/plain")
    @POST("renamehomeschedule")
    fun postRenameHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("name") name: String,
            @Query("home_id") homeId: String
    ): Call<BaseResult>

    @POST("synchomeschedule")
    fun setSyncHomeSchedule(
            @Body body: SetHomeScheduleBody
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("synchomeschedule")
    fun setSyncHomeScheduleGet(
            @Body body: Body
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @POST("setroomthermmode")
    fun setRoomThermMode(
            @Query("home_id") homeId: String,
            @Query("mode") mode: Mode,
            @Query("endtime") endtime: Long?
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("setroomthermmode")
    fun setRoomThermModeGet(
            @Query("home_id") homeId: String,
            @Query("mode") mode: Mode,
            @Query("endtime") endtime: Long?
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @POST("setroomthermpoint")
    fun setRoomThermPoint(
            @Query("home_id") homeId: String,
            @Query("room_id") roomId: String,
            @Query("mode") mode: ThermPointMode,
            @Query("temp") temp: Float? = null,
            @Query("endtime") endtime: Long? = null
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("setroomthermpoint")
    fun setRoomThermPointGet(
            @Query("home_id") homeId: String,
            @Query("room_id") roomId: String,
            @Query("mode") mode: ThermPointMode,
            @Query("temp") temp: Float? = null,
            @Query("endtime") endtime: Long? = null
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @POST("switchhomeschedule")
    fun setSwitchHomeSchedule(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("switchhomeschedule")
    fun setSwitchHomeScheduleGet(
            @Query("schedule_id") scheduleId: String,
            @Query("home_id") homeId: String
    ): Call<BaseResult>

}
