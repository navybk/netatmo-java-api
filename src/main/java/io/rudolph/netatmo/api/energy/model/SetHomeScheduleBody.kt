package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class SetHomeScheduleBody(
        @JsonProperty("schedule_id")
        var scheduleId: String,

        @JsonProperty("timetable")
        var timetable: List<Timetable>,

        @JsonProperty("zones")
        var zones: List<Zone>,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("home_id")
        var homeId: String,

        @JsonProperty("hg_temp")
        var hgTemp: Float = 8F,

        @JsonProperty("away_temp")
        var awayTemp: Float = 15F
)
