package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Homestatusroom(
        @JsonProperty("id")
        var id: String,

        @JsonProperty("reachable")
        var isReachable: Boolean? = null,

        @JsonProperty("therm_measured_temperature")
        var thermMeasuredTemperature: Int? = null,

        @JsonProperty("heating_power_request")
        var heatingPowerRequest: Int? = null,

        @JsonProperty("therm_setpoint_temperature")
        var thermSetpointTemperature: Int? = null,

        @JsonProperty("therm_setpoint_mode")
        var thermSetpointMode: String? = null,

        @JsonProperty("therm_setpoint_start_time")
        var thermSetpointStartTime: Int? = null,

        @JsonProperty("therm_setpoint_end_time")
        var thermSetpointEndTime: Int? = null
)