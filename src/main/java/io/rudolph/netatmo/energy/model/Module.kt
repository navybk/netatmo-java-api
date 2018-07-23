package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Module(
        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("type")
        var type: DeviceType? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("setup_date")
        var setupDate: Int? = null,

        @JsonProperty("modules_bridged")
        var modulesBridged: List<String>? = null,

        @JsonProperty("room_id")
        var roomId: String? = null,

        @JsonProperty("bridge")
        var bridge: String? = null
)

