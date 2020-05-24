package io.rudolph.netatmo.api.presence.service

import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.presence.model.Events
import io.rudolph.netatmo.api.presence.model.Ping
import io.rudolph.netatmo.api.presence.model.SecurityHome
import retrofit2.http.*


internal interface PresenceService {

    @Headers("Content-Type:text/plain")
    @GET("getcamerapicture")
    suspend fun getCamerapPicture(
            @Query("image_id") imageId: String,
            @Query("key") key: String
    ): String

    @Headers("Content-Type:text/plain")
    @POST("getcamerapicture")
    suspend fun getCamerapPicturePost(
            @Query("image_id") imageId: String,
            @Query("key") key: String
    ): String

    @Headers("Content-Type:text/plain")
    @GET("geteventsuntil")
    suspend fun getEventsUntil(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @POST("geteventsuntil")
    suspend fun getEventsUntilPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @GET("gethomedata")
    suspend fun getHomeData(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String? = null,
            @Query("size") eventId: String? = null
    ): TypedBaseResult<SecurityHome>

    @Headers("Content-Type:text/plain")
    @POST("gethomedata")
    suspend fun getHomeDataPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String? = null,
            @Query("size") eventId: String? = null
    ): TypedBaseResult<SecurityHome>

    @Headers("Content-Type:text/plain")
    @GET("getnextevents")
    suspend fun getNextEvents(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String,
            @Query("size") size: Int? = null
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @POST("getnextevents")
    suspend fun getNextEventsPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String,
            @Query("size") size: Int? = null
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @GET
    suspend fun ping(
            @Url url: String
    ): Ping

    @Headers("Content-Type:text/plain")
    @GET("addwebhook")
    suspend fun addWebHookGet(
            @Query("access_token") accessToken: String,
            @Query("url") url: String,
            @Query("app_types") app_types: String = "app_security"
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("addwebhook")
    suspend fun addWebHook(
            @Query("access_token") accessToken: String,
            @Query("url") url: String,
            @Query("app_types") appTypes: String = "app_security"
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @GET("dropwebhook")
    suspend fun dropWebHook(
            @Query("access_token") accessToken: String,
            @Query("app_types") appTypes: String = "app_security"
    ): BaseResult
}