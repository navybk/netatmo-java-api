package io.rudolph.netatmo.oauth2.networkinterceptor

import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.oauth2.*
import io.rudolph.netatmo.oauth2.model.AuthResponse
import io.rudolph.netatmo.oauth2.model.ErrorResult
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class AuthInterceptor(private val userMail: String?,
                               private val userPassword: String?,
                               private val clientId: String?,
                               private val clientSecret: String?,
                               private val authEndpoint: String,
                               private val refreshEndpoint: String = authEndpoint,
                               private val tokenStore: TokenStorage) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val accessToken: String = tokenStore.accessToken ?: let {
            tokenStore.refreshToken?.let {
                refresh(chain) ?: return chain.errorbuilder(0, ErrorResult.Error(0, "refresh failed"))
            } ?: login(chain) ?: return chain.errorbuilder(0, ErrorResult.Error(0, "login failed"))
        }

        chain.proceed(accessToken).let { response ->
            if (response.isSuccessful) {
                return response
            }
            val error = response.createErrorBody()
            return if (response.code() == 403) {
                when (error.code) {
                    3, 2 -> {
                        val accToken = refresh(chain) ?: return chain.errorbuilder(response.code(), error)
                        tokenStore.accessToken = accToken
                        chain.proceed(accToken).let {
                            if (it.isSuccessful) {
                                it
                            } else {
                                val error = it.createErrorBody()
                                chain.errorbuilder(it.code(), error)
                            }
                        }
                    }
                    13 -> {
                        chain.errorbuilder(response.code(), error)
                    }
                    else -> {
                        response
                    }
                }
            } else {
                response
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

        return Request.Builder()
                .url(refreshEndpoint)
                .method("POST", formBody)
                .build()
                .let {
                    proceedAuthRequest(chain, it)
                } ?: return login(chain)
    }

    private fun login(chain: Interceptor.Chain): String? {
        userMail ?: throw IllegalStateException("relogin with usermail not possible")
        userPassword ?: throw IllegalStateException("relogin with user password not possible")
        clientId ?: throw IllegalStateException("relogin with client id not possible")
        clientSecret ?: throw IllegalStateException("relogin with client secret not possible")

        val scopeList = tokenStore.scope.joinToString(" ") { it.value }

        val formBody = FormBody.Builder()
                .addEncoded("password", userPassword)
                .addEncoded("username", userMail)
                .addEncoded("client_secret", clientSecret)
                .addEncoded("client_id", clientId)
                .addEncoded("grant_type", "password")
                .addEncoded("scope", scopeList)
                .build()

        val newRequest = Request.Builder()
                .url(authEndpoint)
                .method("POST", formBody)
                .build()

        return proceedAuthRequest(chain, newRequest)
    }

    private fun proceedAuthRequest(chain: Interceptor.Chain, request: Request): String? {
        return chain.proceed(request)?.let {
            if (!it.isSuccessful) {
                return@let null
            }
            it.body()
                    ?.string()
                    ?.let {
                        JacksonTransform.deserialize<AuthResponse>(it)
                                ?.let {
                                    if (!(it.scope.sortedBy { it.value }.toTypedArray() contentEquals tokenStore.scope.sortedBy { it.value }.toTypedArray())) {
                                        logger.warn("Scope from response does not match requested scope")
                                    }
                                    tokenStore.setTokens(it.accessToken, it.refreshToken, it.scope)
                                    it.accessToken
                                }
                    }
        }
    }

}