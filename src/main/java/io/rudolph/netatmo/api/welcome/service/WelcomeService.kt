package io.rudolph.netatmo.api.welcome.service

import io.rudolph.netatmo.api.energy.model.BaseResult
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.presence.model.Events
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


internal interface WelcomeService {

    @Headers("Content-Type:text/plain")
    @GET("getlasteventof")
    fun getLastEventOf(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String,
            @Query("offset") offset: Int? = null
    ): Call<TypedBaseResult<Events>>

    @Headers("Content-Type:text/plain")
    @POST("getlasteventof")
    fun getLastEventOfPost(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String,
            @Query("offset") offset: Int? = null
    ): Call<TypedBaseResult<Events>>

    @Headers("Content-Type:text/plain")
    @GET("setpersonsaway")
    fun setPersonsAwayGet(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String? = null
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @POST("setpersonsaway")
    fun setPersonsAway(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_id") personId: String? = null
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @GET("setpersonshome")
    fun setPersonsHomeGet(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_ids") personIds: List<String>
    ): Call<BaseResult>

    @Headers("Content-Type:text/plain")
    @POST("setpersonshome")
    fun setPersonsHome(
            @Query("access_token") accessToken: String,
            @Query("home_id") homeId: String,
            @Query("person_ids") personIds: List<String>
    ): Call<BaseResult>

}