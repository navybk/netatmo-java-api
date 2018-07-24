package io.rudolph.netatmo

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import io.rudolph.netatmo.energy.EnergyApi
import io.rudolph.netatmo.oauth2.TokenStorage
import io.rudolph.netatmo.oauth2.model.Scope
import io.rudolph.netatmo.oauth2.networkinterceptor.AuthInterceptor
import io.rudolph.netatmo.oauth2.networkinterceptor.TimeoutInterceptor
import io.rudolph.netatmo.transform.JacksonTransform
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


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

    var accessToken: String? = null
        private set

    var refreshToken: String? = null
        private set

    private val tokenStorage = TokenStorage(accessToken, refreshToken).apply {
        onRefreshTokenUpdate = { accessToken: String, refreshToken: String ->
            this.accessToken = accessToken
            this.refreshToken = refreshToken
        }
    }

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
            apiEndpoint= BASEAPIENDPOINT,
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
            apiEndpoint= BASEAPIENDPOINT,
            debug = false)

    private val api = OkHttpClient.Builder()
            .addInterceptor(
                    AuthInterceptor(userMail = userMail,
                            userPassword = userPassword,
                            clientId = clientId,
                            clientSecret = clientSecret,
                            scope = scope,
                            authEndpoint = authEndpoint,
                            refreshEndpoint = refreshEndpoint,
                            tokenStore = tokenStorage))
            .addInterceptor(TimeoutInterceptor(debug))
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


    val energyApi = EnergyApi(api)
}