package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Zone(
        @JsonProperty("type")
        var type: Int? = null,

        @JsonProperty("id")
        var id: Int? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("rooms_temp")
        var roomsTemp: List<RoomsTemp>? = null
)