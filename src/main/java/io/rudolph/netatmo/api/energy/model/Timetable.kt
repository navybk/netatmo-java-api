package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty


data class Timetable(
        @param: JsonProperty("zone_id")
        @field: JsonProperty("zone_id")
        @field:JsonAlias("zone_id", "id")
        val zoneId: Int? = null,

        @param: JsonProperty("m_offset")
        @field: JsonProperty("m_offset")
        val mOffset: Int? = null
)