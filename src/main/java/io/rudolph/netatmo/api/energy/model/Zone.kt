package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Zone(
        @JsonProperty("type")
        var type: ZoneType? = null,

        @JsonProperty("id")
        var id: Int? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("rooms_temp")
        var roomsTemp: List<RoomsTemp>? = null,

        @JsonProperty("rooms")
        var rooms: List<ScheduleRoom>? = null
)