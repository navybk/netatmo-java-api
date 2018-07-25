package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class User(
        @JsonProperty("reg_locale")
        private val regLocale: String? = null,

        @JsonProperty("lang")
        private val lang: String? = null
)