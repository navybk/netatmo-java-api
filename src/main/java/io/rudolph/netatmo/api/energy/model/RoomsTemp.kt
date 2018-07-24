package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class RoomsTemp(
        @JsonProperty("temp")
        var temp: Float? = null,

        @JsonProperty("room_id")
        var roomId: String? = null
)
