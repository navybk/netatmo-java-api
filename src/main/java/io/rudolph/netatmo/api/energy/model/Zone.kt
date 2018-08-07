package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Zone(
        @JsonProperty("type")
        val type: ZoneType? = null,

        @JsonProperty("id")
        val id: Int? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("rooms_temp")
        val roomsTemp: List<RoomsTemp>? = null,

        @JsonProperty("rooms")
        val rooms: List<ScheduleRoom>? = null,

        @JsonProperty("temp")
        val temp: Float? = null
)