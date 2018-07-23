package io.rudolph.netatmo

import io.rudolph.netatmo.energy.EnergyApi
import io.rudolph.netatmo.oauth2.AuthInterceptor
import io.rudolph.netatmo.oauth2.TokenStorage
import io.rudolph.netatmo.oauth2.model.Scope
import io.rudolph.netatmo.transform.JacksonTransform
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


class NetatmoApi(userMail: String? = null,
                 userPassword: String? = null,
                 clientId: String? = null,
                 clientSecret: String? = null,
                 apiEndpoint: String = "https://api.netatmo.com/api/",
                 authEndpoint: String = "https://api.netatmo.com/oauth2/token",
                 scope: List<Scope>,
                 accessToken: String? = null,
                 refreshToken: String? = null,
                 debug: Boolean = false
) {

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

    private val api = OkHttpClient.Builder()
            .addInterceptor(
                    AuthInterceptor(userMail = userMail,
                            userPassword = userPassword,
                            clientId = clientId,
                            clientSecret = clientSecret,
                            scope = scope,
                            authEndpoint = authEndpoint,
                            tokenStore = tokenStorage))
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
                        .baseUrl(apiEndpoint)
                        .client(it)
                        .build()
            }


    val energyApi = EnergyApi(api)
}