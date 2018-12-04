package io.rudolph.netatmo.oauth2.model

import com.fasterxml.jackson.annotation.JsonProperty

data class BackendError(
        @JsonProperty("code")
        val code: Int? = null,

        @JsonProperty("message")
        val message: String? = null
)