package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class BaseDevice(
        @JsonProperty("_id")
        override val id: String? = null
) : Device() {
    @JsonProperty("type")
    override val type: DeviceType = DeviceType.UNKNOWN
}