package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ThermostatModule(
        @JsonProperty("modules_bridged")
        val modulesBridged: List<String>? = null,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_status")
        val boilerStatus: String? = null,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_valve_comfort_boost")
        val boilerValveComfortBoost: String? = null,

        @JsonProperty("setpoint")
        val setPoint: SetPoint? = null,

        @JsonProperty("therm_program_list")
        val thermProgramList: List<ThermProgram> = listOf(),

        @JsonProperty("measured")
        val measure: Measure? = null,

        @JsonProperty("firmware")
        val firmware: Int? = null,

        @JsonAlias("last_seen", "last_therm_seen")
        val lastSeen: LocalDateTime? = null,

        @JsonProperty("last_message")
        val lastMessage: LocalDateTime? = null,

        @JsonProperty("therm_orientation")
        val thermOrientation: Int? = null,

        @JsonProperty("therm_relay_cmd")
        val thermRelayCmd: Int? = null,

        @JsonProperty("battery_vp")
        val batteryVp: Int? = null


) : ValveBaseModule()