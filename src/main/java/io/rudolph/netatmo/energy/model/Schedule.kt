package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Schedule(
        @JsonProperty("timetable")
        var timetable: List<Timetable>? = null,

        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("away_temp")
        var awayTemp: Int? = null,

        @JsonProperty("zones")
        var zones: List<Zone>? = null,

        @JsonProperty("hg_temp")
        var hgTemp: Int? = null,

        @JsonProperty("selected")
        var isSelected: Boolean? = null,

        @JsonProperty("type")
        var type: String? = null,

        @JsonProperty("default")
        var default: Boolean = false
)
