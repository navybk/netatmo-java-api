package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType

data class ThermosthatModule(
        @JsonProperty("modules_bridged")
        var modulesBridged: List<String>? = null,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_status")
        var boilerStatus: String? = null,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_valve_comfort_boost")
        var boilerValveComfortBoost: String? = null

) : ValveBaseModule() {
    override val type = DeviceType.THERMOSTAT
}