package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Measure(
        @JsonProperty("time")
        val time: LocalDateTime,

        @JsonProperty("temperature")
        val temperature: Float? = null,

        @JsonProperty("setpoint_temp")
        val setpointTemp: Float? = null
)