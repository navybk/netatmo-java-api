package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


/**
 * BaseRoom status definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class BaseRoom(
        /**
         * Id of the room
         */
        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("type")
        val type: RoomType,

        @JsonProperty("module_ids")
        val moduleIds: List<String>? = null,

        @JsonProperty("measure_offset_NAPlug_temperature")
        val measureOffsetNAPlugTemperature: Int? = null,

        @JsonProperty("measure_offset_NAPlug_estimated_temperature")
        val measureOffsetNAPlugEstimatedTemperature: Int? = null
)