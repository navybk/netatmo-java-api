package io.rudolph.netatmo.oauth2

import io.rudolph.netatmo.oauth2.model.Scope


internal data class TokenStorage(private var _accessToken: String? = null,
                                 var refreshToken: String? = null,
                                 var scope: List<Scope> = listOf()) {

    var accessToken: String?
        get() = _accessToken
        set(value) {
            _accessToken = value
            value?.apply {
                onAccessTokenUpdate(this)
            }
        }

    var onAccessTokenUpdate: (String) -> Unit = {}
    var onRefreshTokenUpdate: (String, String) -> Unit = { acc: String, refresh: String -> }

    fun setTokens(accToken: String, refrToken: String) {
        _accessToken = accToken
        refreshToken = refrToken
        onRefreshTokenUpdate(accToken, refrToken)
    }
}