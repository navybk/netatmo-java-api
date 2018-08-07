package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType

data class RelayModule(
        @JsonProperty("modules_bridged")
        val modulesBridged: List<String>? = null,

        /**
         * Only for NAPlug
         */
        @JsonProperty("connected_to_boiler")
        val connectedToBoiler: Boolean? = false

) : EnergyModule() {
    override val type = DeviceType.THERMOSTAT
}