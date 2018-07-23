package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class ScheduleRoom(
        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("therm_setpoint_temperature")
        var thermSetpointTemperature: Int? = null
)