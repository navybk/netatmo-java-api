package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


data class HomeStatusRoom(

        /**
         * Id of the room
         */
        @JsonProperty("id")
        var id: String,

        /**
         * False if none of the module of the room are reachable
         */
        @JsonProperty("reachable")
        var isReachable: Boolean? = null,

        /**
         * Ambient temperature
         */
        @JsonProperty("therm_measured_temperature")
        var thermMeasuredTemperature: Float? = null,

        /**
         * Only if room has valves
         */
        @JsonProperty("heating_power_request")
        var heatingPowerRequest: Float? = null,

        /**
         * setpoint temprature
         */
        @JsonProperty("therm_setpoint_temperature")
        var thermSetpointTemperature: Float? = null,

        /**
         * manual
         * max
         * off
         * schedule
         * away
         * hg
         */
        @JsonProperty("therm_setpoint_mode")
        var thermSetpointMode: ThermMode? = null,

        /**
         * Start time for a manual setpoint
         */
        @JsonProperty("therm_setpoint_start_time")
        var thermSetpointStartTime: LocalDateTime? = null,

        /**
         * End time for a manual setpoint
         */
        @JsonProperty("therm_setpoint_end_time")
        var thermSetpointEndTime: LocalDateTime? = null
)