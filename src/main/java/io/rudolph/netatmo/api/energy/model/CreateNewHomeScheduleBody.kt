package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


class CreateNewHomeScheduleBody(
        @JsonProperty("home_id")
        var homeId: String? = null,

        @JsonProperty("timetable")
        var timetable: MutableList<Timetable>? = null,

        @JsonProperty("zones")
        var zones: MutableList<Zone>? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("hg_temp")
        var hgTemp: Float? = null,

        @JsonProperty("away_temp")
        var awayTemp: Float? = null

)

