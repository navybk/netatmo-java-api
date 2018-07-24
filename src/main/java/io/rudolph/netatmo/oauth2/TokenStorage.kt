package io.rudolph.netatmo.oauth2

import io.rudolph.netatmo.oauth2.model.Scope


internal data class TokenStorage(private var _accessToken: String? = null,
                                 var refreshToken: String? = null,
                                 private val _scope: List<Scope>) {

    var scope: List<Scope> = _scope
        private set

    var accessToken: String? = _accessToken
        get() = _accessToken

    var onRefreshTokenUpdate: (String, String, List<Scope>) -> Unit = { _: String, _: String, _: List<Scope> -> }

    fun setTokens(accToken: String, refrToken: String, scope: List<Scope>) {
        _accessToken = accToken
        refreshToken = refrToken
        this.scope = scope
        onRefreshTokenUpdate(accToken, refrToken, scope)
    }
}