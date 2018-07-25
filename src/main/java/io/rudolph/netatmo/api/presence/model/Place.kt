package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Place(
        @JsonProperty("country")
        private val country: String? = null,

        @JsonProperty("city")
        private val city: String? = null,

        @JsonProperty("timezone")
        private val timezone: String? = null
)