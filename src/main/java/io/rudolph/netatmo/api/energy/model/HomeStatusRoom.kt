package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


data class HomeStatusRoom(

        /**
         * Id of the room
         */
        @JsonProperty("id")
        val id: String,

        /**
         * False if none of the module of the room are reachable
         */
        @JsonProperty("reachable")
        val isReachable: Boolean? = null,

        /**
         * Ambient temperature
         */
        @JsonProperty("therm_measured_temperature")
        val thermMeasuredTemperature: Float? = null,

        /**
         * Only if room has valves
         */
        @JsonProperty("heating_power_request")
        val heatingPowerRequest: Float? = null,

        /**
         * setpoint temperature
         */
        @JsonProperty("therm_setpoint_temperature")
        val thermSetpointTemperature: Float? = null,

        /**
         * manual
         * max
         * off
         * schedule
         * away
         * hg
         */
        @JsonProperty("therm_setpoint_mode")
        val thermSetpointMode: ThermMode? = null,

        /**
         * Start time for a manual setpoint
         */
        @JsonProperty("therm_setpoint_start_time")
        val thermSetpointStartTime: LocalDateTime? = null,

        /**
         * End time for a manual setpoint
         */
        @JsonProperty("therm_setpoint_end_time")
        val thermSetpointEndTime: LocalDateTime? = null
)