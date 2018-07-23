package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomeStatusModule(
        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("type")
        var type: DeviceType? = null,

        @JsonProperty("rf_strength")
        var rfStrength: Int? = null,

        @JsonProperty("battery_level")
        var batteryLevel: Int? = null,

        @JsonProperty("bridge")
        var bridge: String? = null,

        @JsonProperty("battery_state")
        var batteryState: String? = null,

        @JsonProperty("wifi_strength")
        var wifiStrength: Int? = null,

        @JsonProperty("reachable")
        var isReachable: Boolean? = null,

        @JsonProperty("firmware_revision")
        var firmwareRevision: Int? = null
)
