package io.rudolph.netatmo.api.welcome.service

import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.presence.model.Events
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


internal interface WelcomeService {

    @Headers("Content-Type:text/plain")
    @GET("getlasteventof")
    suspend fun getLastEventOf(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String,
            @Query("offset") offset: Int? = null
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @POST("getlasteventof")
    suspend fun getLastEventOfPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String,
            @Query("offset") offset: Int? = null
    ): TypedBaseResult<Events>

    @Headers("Content-Type:text/plain")
    @GET("setpersonsaway")
    suspend fun setPersonsAwayGet(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String? = null
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("setpersonsaway")
    suspend fun setPersonsAway(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String? = null
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @GET("setpersonshome")
    suspend fun setPersonsHomeGet(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_ids") personIds: List<String>
    ): BaseResult

    @Headers("Content-Type:text/plain")
    @POST("setpersonshome")
    suspend fun setPersonsHome(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_ids") personIds: List<String>
    ): BaseResult

}