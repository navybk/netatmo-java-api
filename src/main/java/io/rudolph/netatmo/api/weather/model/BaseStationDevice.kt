package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.rudolph.netatmo.api.common.model.Device
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.common.model.Module
import io.rudolph.netatmo.api.weather.transform.ModuleDeserializer

data class BaseStationDevice(
        @JsonProperty("type")
        override val type: DeviceType = DeviceType.BASESTATION,

        @JsonProperty("modules")
        @JsonDeserialize(using = ModuleDeserializer::class)
        val modules: List<Module>? = null
): Device()