package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonProperty


data class BaseDevice(
        @JsonProperty("_id")
        override val id: String? = null
) : Device() {
    @JsonProperty("type")
    override val type: DeviceType = DeviceType.UNKNOWN
}