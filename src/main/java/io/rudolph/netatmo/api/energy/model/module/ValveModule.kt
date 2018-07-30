package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType

data class ValveModule(
        @JsonProperty("id")
        override val id: String? = null
) : ValveBaseModule() {
    override val type = DeviceType.VALVE
}