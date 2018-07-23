package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class ThermScheduleZones(
        @JsonProperty("timetable")
        var timetable: ThermScheduleTimetable? = null,

        @JsonProperty("hg_temp")
        var hgTemp: Int? = null,

        @JsonProperty("away_temp")
        var awayTemp: Int? = null,

        @JsonProperty("selected")
        var isSelected: Boolean? = null,

        @JsonProperty("type")
        var type: String? = null,

        @JsonProperty("name")
        var Name: String? = null,

        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("zones")
        var zones: List<Zone>? = null,

        @JsonProperty("rooms_temp")
        var roomstemp: List<RoomsTemp>? = null

)