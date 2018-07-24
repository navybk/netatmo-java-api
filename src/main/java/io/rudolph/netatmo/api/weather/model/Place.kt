package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Place(
        @JsonProperty("location")
        val location: MutableList<Float>,

        @JsonProperty("altitude")
        val altitude: Float,

        @JsonProperty("timezone")
        val timezone: String
)