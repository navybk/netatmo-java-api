package io.rudolph.netatmo.api.security.service

import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.security.model.Events
import io.rudolph.netatmo.api.security.model.Ping
import io.rudolph.netatmo.api.security.model.SecurityHomeData
import retrofit2.http.*


internal interface SecurityService {

    @Headers("Content-Type:text/plain")
    @GET("getlasteventof")
    suspend fun getLastEventOf(
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String,
            @Query("offset") offset: Int? = null
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @POST("setpersonsaway")
    suspend fun setPersonsAway(
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String? = null
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("setpersonshome")
    suspend fun setPersonsHome(
            @Query("home_id") homeId: String,
            @Query("person_ids") personIds: List<String>
    ): BaseResult


    @Headers("Content-Type:text/plain")
    @GET("getcamerapicture")
    suspend fun getCamerapPicture(
            @Query("image_id") imageId: String,
            @Query("key") key: String
    ): String

    @Headers("Content-Type:text/plain")
    @GET("geteventsuntil")
    suspend fun getEventsUntil(
            @Query("home_id") homeId: String,
            @Query("event_id") eventId: String
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @GET("gethomedata")
    suspend fun getHomeData(
            @Query("home_id") homeId: String? = null,
            @Query("size") eventId: String? = null
    ): TypedBaseResult<SecurityHomeData>

    @Headers("Content-Type:text/plain")
    @GET("getnextevents")
    suspend fun getNextEvents(
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
    @POST("addwebhook")
    suspend fun addWebHook(
            @Query("url") url: String,
            @Query("app_types") appTypes: String = "app_security"
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @GET("dropwebhook")
    suspend fun dropWebHook(): BaseResult
}