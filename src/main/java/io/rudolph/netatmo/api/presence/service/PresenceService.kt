package io.rudolph.netatmo.api.presence.service

import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.presence.model.Events
import io.rudolph.netatmo.api.presence.model.Ping
import io.rudolph.netatmo.api.presence.model.SecurityHome
import retrofit2.Call
import retrofit2.http.*


internal interface PresenceService {

    @Headers("Content-Type:text/plain")
    @GET("getcamerapicture")
    fun getCamerapPicture(
            @Query("image_id") imageId: String,
            @Query("key") key: String
    ): Call<String>

    @Headers("Content-Type:text/plain")
    @POST("getcamerapicture")
    fun getCamerapPicturePost(
            @Query("image_id") imageId: String,
            @Query("key") key: String
    ): Call<String>

    @Headers("Content-Type:text/plain")
    @GET("geteventsuntil")
    fun getEventsUntil(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String
    ): Call<TypedBaseResult<Events>>

    @Headers("Content-Type:text/plain")
    @POST("geteventsuntil")
    fun getEventsUntilPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String
    ): Call<TypedBaseResult<Events>>

    @Headers("Content-Type:text/plain")
    @GET("gethomedata")
    fun getHomeData(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String? = null,
            @Query("size") eventId: String? = null
    ): Call<TypedBaseResult<SecurityHome>>

    @Headers("Content-Type:text/plain")
    @POST("gethomedata")
    fun getHomeDataPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String? = null,
            @Query("size") eventId: String? = null
    ): Call<TypedBaseResult<SecurityHome>>

    @Headers("Content-Type:text/plain")
    @GET("getnextevents")
    fun getNextEvents(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String,
            @Query("size") size: Int? = null
    ): Call<TypedBaseResult<Events>>

    @Headers("Content-Type:text/plain")
    @POST("getnextevents")
    fun getNextEventsPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String,
            @Query("size") size: Int? = null
    ): Call<TypedBaseResult<Events>>

    @Headers("Content-Type:text/plain")
    @GET("/command/ping")
    fun ping(
            @Url url: String
    ): Call<Ping>

    @Headers("Content-Type:text/plain")
    @GET("addwebhook")
    fun addWebHookGet(
            @Query("access_token") accessToken: String,
            @Query("url") url: String,
            @Query("app_types") app_types: String = "app_security"
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @POST("addwebhook")
    fun addWebHook(
            @Query("access_token") accessToken: String,
            @Query("url") url: String,
            @Query("app_types") appTypes: String = "app_security"
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("dropwebhook")
    fun dropWebHook(
            @Query("access_token") accessToken: String,
            @Query("app_types") appTypes: String = "app_security"
    ): Call<BaseResult>
}