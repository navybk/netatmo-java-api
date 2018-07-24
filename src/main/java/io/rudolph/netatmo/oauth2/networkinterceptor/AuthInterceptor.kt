package io.rudolph.netatmo.oauth2.networkinterceptor

import io.rudolph.netatmo.oauth2.TokenStorage
import io.rudolph.netatmo.oauth2.errorbuilder
import io.rudolph.netatmo.oauth2.model.AuthResponse
import io.rudolph.netatmo.oauth2.model.Scope
import io.rudolph.netatmo.oauth2.proceed
import io.rudolph.netatmo.transform.JacksonTransform
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class AuthInterceptor(private val userMail: String?,
                               private val userPassword: String?,
                               private val clientId: String?,
                               private val clientSecret: String?,
                               private val scope: List<Scope>,
                               private val authEndpoint: String,
                               private val refreshEndpoint: String = authEndpoint,
                               private val tokenStore: TokenStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val accessToken: String = tokenStore.accessToken ?: let {
            tokenStore.refreshToken?.let {
                refresh(chain) ?: return chain.errorbuilder("refresh failed")
            } ?: login(chain) ?: return chain.errorbuilder("login failed")
        }

        return chain.proceed(accessToken).let {
            if (it.code() == 403) {
                val accToken = refresh(chain) ?: return chain.errorbuilder("access denied")
                chain.proceed(accToken)
            } else {
                it
            }
        }
    }

    private fun refresh(chain: Interceptor.Chain): String? {
        val refreshToken = tokenStore.refreshToken ?: return login(chain)

        clientId ?: throw IllegalStateException("relogin with client id not pssible")
        clientSecret ?: throw IllegalStateException("relogin with client secret not pssible")

        val formBody = FormBody.Builder()
                .addEncoded("refresh_token", refreshToken)
                .addEncoded("client_secret", clientSecret)
                .addEncoded("client_id", clientId)
                .addEncoded("grant_type", "refresh_token")
                .build()

        return chain.request()
                .newBuilder()
                .url(refreshEndpoint)
                .method("POST", formBody)
                .build()
                .let {
                    proceedAuthRequest(chain, it) ?: return login(chain)
                }
    }

    private fun login(chain: Interceptor.Chain): String? {
        userMail ?: throw IllegalStateException("relogin with usermail not pssible")
        userPassword ?: throw IllegalStateException("relogin with user password not pssible")
        clientId ?: throw IllegalStateException("relogin with client id not pssible")
        clientSecret ?: throw IllegalStateException("relogin with client secret not pssible")

        val scopeList = scope.joinToString(" ") { it.value }

        val formBody = FormBody.Builder()
                .addEncoded("password", userPassword)
                .addEncoded("username", userMail)
                .addEncoded("client_secret", clientSecret)
                .addEncoded("client_id", clientId)
                .addEncoded("grant_type", "password")
                .addEncoded("scope", scopeList)
                .build()

        val newRequest = chain.request()
                .newBuilder()
                .url(authEndpoint)
                .method("POST", formBody)
                .build()

        return proceedAuthRequest(chain, newRequest)
    }

    private fun proceedAuthRequest(chain: Interceptor.Chain, request: Request): String? {
        return chain.proceed(request)?.body()?.string()?.let {
            JacksonTransform.deserialize<AuthResponse>(it)
                    ?.let {
                        tokenStore.setTokens(it.accessToken, it.refreshToken)
                        it.accessToken
                    }
        }
    }

}