package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


class CreateNewHomeScheduleBody(
        @JsonProperty("home_id")
        val homeId: String? = null,

        @JsonProperty("timetable")
        val timetable: MutableList<Timetable>? = null,

        @JsonProperty("zones")
        val zones: MutableList<Zone>? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("hg_temp")
        val hgTemp: Float? = null,

        @JsonProperty("away_temp")
        val awayTemp: Float? = null

)

