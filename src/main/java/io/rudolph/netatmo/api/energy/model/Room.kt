package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


/**
 * Room status definition
 */
data class Room(
        /**
         * Id of the room
         */
        @JsonProperty("id")
        var id: String? = null,

        /**
         * setpoint temprature
         */
        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("type")
        var type: String? = null,

        @JsonProperty("module_ids")
        var moduleIds: List<String>? = null,

        @JsonProperty("measure_offset_NAPlug_temperature")
        var measureOffsetNAPlugTemperature: Int? = null,

        @JsonProperty("measure_offset_NAPlug_estimated_temperature")
        var measureOffsetNAPlugEstimatedTemperature: Int? = null
)