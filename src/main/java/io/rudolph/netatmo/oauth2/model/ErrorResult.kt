package io.rudolph.netatmo.oauth2.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorResult(
        @JsonProperty("error")
        val error: Error
) {


    data class Error(
            @JsonProperty("code")
            val code: Int? = null,

            @JsonProperty("message")
            val message: String? = null)
}