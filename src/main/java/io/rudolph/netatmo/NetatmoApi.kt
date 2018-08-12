package io.rudolph.netatmo

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import io.rudolph.netatmo.api.aircare.AirCareConnector
import io.rudolph.netatmo.api.energy.EnergyConnector
import io.rudolph.netatmo.api.presence.PresenceConnector
import io.rudolph.netatmo.api.weather.WeatherConnector
import io.rudolph.netatmo.api.welcome.WelcomeConnector
import io.rudolph.netatmo.oauth2.TokenStorage
import io.rudolph.netatmo.oauth2.model.Scope
import io.rudolph.netatmo.oauth2.networkinterceptor.AuthInterceptor
import io.rudolph.netatmo.oauth2.networkinterceptor.TimeoutInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


class NetatmoApi(userMail: String? = null,
                 userPassword: String? = null,
                 clientId: String? = null,
                 clientSecret: String? = null,
                 apiEndpoint: String = BASEAPIENDPOINT,
                 authEndpoint: String = AUTHENDPOINT,
                 refreshEndpoint: String = AUTHENDPOINT,
                 scope: List<Scope>,
                 accessToken: String? = null,
                 refreshToken: String? = null,
                 debug: Boolean = false
) {

    private companion object {
        const val BASEAPIENDPOINT = "https://api.netatmo.com/api/"
        const val AUTHENDPOINT = "https://api.netatmo.com/oauth2/token"
    }

    private val tokenStorage = TokenStorage(accessToken, refreshToken, scope)

    fun settokenRefreshCallback(callback: TokenRefreshCallback) {
        tokenStorage.onRefreshTokenUpdate = { accessToken: String, refreshToken: String, scopeList: List<Scope> -> callback.onTokenReceived(accessToken, refreshToken, scopeList) }
    }

    fun setTokenRefreshFunction(function: (accessToken: String, refreshToken: String, scopeList: List<Scope>) -> Unit) {
        tokenStorage.onRefreshTokenUpdate = function
    }

    val accessToken: String?
        get() = tokenStorage.accessToken

    val refreshToken: String?
        get() = tokenStorage.refreshToken

    constructor(userMail: String,
                userPassword: String,
                clientId: String,
                clientSecret: String,
                scope: List<Scope>,
                accessToken: String?,
                refreshToken: String?)
            : this(userMail = userMail,
            userPassword = userPassword,
            clientId = clientId,
            clientSecret = clientSecret,
            scope = scope,
            accessToken = accessToken,
            refreshToken = refreshToken,
            apiEndpoint = BASEAPIENDPOINT,
            debug = false)

    constructor(userMail: String,
                userPassword: String,
                clientId: String,
                clientSecret: String,
                scope: List<Scope>)
            : this(userMail = userMail,
            userPassword = userPassword,
            clientId = clientId,
            clientSecret = clientSecret,
            scope = scope,
            apiEndpoint = BASEAPIENDPOINT,
            debug = false)

    private val api = OkHttpClient.Builder()
            .addInterceptor(
                    AuthInterceptor(userMail = userMail,
                            userPassword = userPassword,
                            clientId = clientId,
                            clientSecret = clientSecret,
                            authEndpoint = authEndpoint,
                            refreshEndpoint = refreshEndpoint,
                            tokenStore = tokenStorage))
            .addInterceptor(TimeoutInterceptor(debug))
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .apply {
                if (debug) {
                    val logging = HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                    addInterceptor(logging)
                }
            }
            .build()
            .let {
                Retrofit.Builder()
                        .addConverterFactory(JacksonTransform.jacksonConverterFactory)
                        .addCallAdapterFactory(CoroutineCallAdapterFactory())
                        .baseUrl(apiEndpoint)
                        .client(it)
                        .build()
            }


    val energyApi = EnergyConnector(api)
    val weatherApi = WeatherConnector(api)
    val airCareApi = AirCareConnector(api)
    val presenceApi = PresenceConnector(api)
    val welcomeApi = WelcomeConnector(api)
}