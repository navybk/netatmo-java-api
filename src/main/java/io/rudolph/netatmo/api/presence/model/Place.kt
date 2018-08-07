package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Place(
        @JsonProperty("country")
        val country: String? = null,

        @JsonProperty("city")
        val city: String? = null,

        @JsonProperty("timezone")
        val timezone: String? = null
)