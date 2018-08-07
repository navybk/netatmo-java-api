package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class RoomsTemp(
        @JsonProperty("temp")
        val temp: Float? = null,

        @JsonProperty("room_id")
        val roomId: String? = null
)
