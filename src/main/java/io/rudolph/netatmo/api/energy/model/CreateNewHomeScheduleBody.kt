package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


class CreateNewHomeScheduleBody(
        @JsonProperty("home_id")
        val homeId: String? = null,

        @JsonProperty("timetable")
        val timetable: List<Timetable>? = null,

        @JsonProperty("zones")
        val zones: List<Zone>? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("hg_temp")
        val hgTemp: Float? = null,

        @JsonProperty("away_temp")
        val awayTemp: Float? = null

)

