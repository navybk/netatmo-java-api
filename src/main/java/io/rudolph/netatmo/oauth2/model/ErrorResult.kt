package io.rudolph.netatmo.oauth2.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorResult(
        @JsonProperty("error")
        val error: BackendError
)