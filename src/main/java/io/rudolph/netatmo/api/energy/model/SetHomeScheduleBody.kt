package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class SetHomeScheduleBody(
        @JsonProperty("schedule_id")
        val scheduleId: String,

        @JsonProperty("timetable")
        val timetable: List<Timetable>,

        @JsonProperty("zones")
        val zones: List<Zone>,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("home_id")
        val homeId: String,

        @JsonProperty("hg_temp")
        val hgTemp: Float = 8F,

        @JsonProperty("away_temp")
        val awayTemp: Float = 15F
)
