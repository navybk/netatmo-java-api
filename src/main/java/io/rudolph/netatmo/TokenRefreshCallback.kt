package io.rudolph.netatmo

import io.rudolph.netatmo.oauth2.model.Scope

interface TokenRefreshCallback {

    fun onTokenReceived(accessToken: String, RefreshToken: String, scope: List<Scope>)
}