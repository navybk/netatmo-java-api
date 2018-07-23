package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class ThermSchedule(
        @JsonProperty("timetable")
        var timetable: List<ThermScheduleTimetable>? = null,

        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("away_temp")
        var awayTemp: Int? = null,

        @JsonProperty("zones")
        var zones: List<ThermScheduleZones>? = null,

        @JsonProperty("hg_temp")
        var hgTemp: Int? = null,

        @JsonProperty("selected")
        var selected: Boolean? = null,

        @JsonProperty("type")
        var type: String? = null
)