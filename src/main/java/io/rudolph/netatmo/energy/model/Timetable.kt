package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Timetable(
        @param: JsonProperty("zone_id")
        @field: JsonProperty("zone_id")
        var zoneId: Int? = null,

        @param: JsonProperty("m_offset")
        @field: JsonProperty("m_offset")
        var mOffset: Int? = null
)