package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Schedule(
        @JsonProperty("timetable")
        val timetable: List<Timetable> = listOf(),

        @JsonProperty("id")
        val id: String,

        @JsonProperty("name")
        val name: String,

        @JsonProperty("away_temp")
        val awayTemp: Int? = null,

        @JsonProperty("zones")
        val zones: List<Zone> = listOf(),

        @JsonProperty("hg_temp")
        val hgTemp: Int? = null,

        @JsonProperty("selected")
        val isSelected: Boolean? = null,

        @JsonProperty("type")
        val type: String? = null,

        @JsonProperty("default")
        val default: Boolean = false
)
