package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class ScheduleRoom(
        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("therm_setpoint_temperature")
        val thermSetpointTemperature: Int? = null
)