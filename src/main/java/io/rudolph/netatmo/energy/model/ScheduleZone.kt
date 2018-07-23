package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class ScheduleZone(
        @JsonProperty("type")
        var type: Int? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("rooms_temp")
        var roomsTemp: List<RoomsTemp>? = null,

        @JsonProperty("id")
        var id: Int? = null,

        @JsonProperty("rooms")
        var rooms: List<ScheduleRoom>? = null
)