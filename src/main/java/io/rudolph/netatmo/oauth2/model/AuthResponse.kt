package io.rudolph.netatmo.oauth2.model

import com.fasterxml.jackson.annotation.JsonProperty


data class AuthResponse(
        @JsonProperty("access_token")
        val accessToken: String,

        @JsonProperty("refresh_token")
        val refreshToken: String,

        @JsonProperty("scope")
        val scope: List<Scope>,

        @JsonProperty("expires_in")
        val expiresInSeconds: Int,

        @JsonProperty("expire_in")
        val expireInSeconds: Int
)