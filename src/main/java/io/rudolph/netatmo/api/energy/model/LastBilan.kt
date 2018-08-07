package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty

data class LastBilan(
        @JsonProperty("y")
        val year: Int,

        @JsonProperty("m")
        val month: Int
)