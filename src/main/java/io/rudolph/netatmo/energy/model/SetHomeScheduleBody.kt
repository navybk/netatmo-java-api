package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class SetHomeScheduleBody(
        @JsonProperty("schedule_id")
        var scheduleId: String? = null,

        @JsonProperty("timetable")
        var timetable: List<Timetable> = listOf(),

        @JsonProperty("zones")
        var zones: List<Baseresult> = listOf(),

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("home_id")
        var homeId: String? = null,

        @JsonProperty("hg_temp")
        var hgTemp: Int? = null,

        @JsonProperty("away_temp")
        var awayTemp: Int? = null
)
