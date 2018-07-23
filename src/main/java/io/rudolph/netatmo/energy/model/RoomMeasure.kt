package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class RoomMeasure(
        @JsonProperty("status")
        var status: String? = null,

        @JsonProperty("time_exec")
        var timeExec: Float? = null,

        @JsonProperty("time_server")
        var timeServer: Int? = null,

        @JsonProperty("body")
        var body: RoomMeasureBody? = null
)