package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class ThermScheduleTimetable(
        @JsonProperty("zone_id")
        var zoneId: Int? = null,

        @JsonProperty("m_offset")
        var mOffset: Int? = null
)