package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Schedule(
        @JsonProperty("zones")
        var zones: List<ScheduleZone>? = null,

        @JsonProperty("timetable")
        var timetable: List<Timetable>? = null,

        @JsonProperty("hg_temp")
        var hgTemp: Int? = null,

        @JsonProperty("away_temp")
        var awayTemp: Int? = null,

        @JsonProperty("selected")
        var isSelected: Boolean? = null,

        @JsonProperty("type")
        var type: String? = null,

        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("name")
        var name: String? = null
)
