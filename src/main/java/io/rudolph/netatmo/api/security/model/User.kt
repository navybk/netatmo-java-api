package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
        @JsonProperty("reg_locale")
        val regLocale: String? = null,

        @JsonProperty("lang")
        val lang: String? = null,

        @JsonProperty("country")
        val country: String? = null,

        @JsonProperty("mail")
        val mail: String
)