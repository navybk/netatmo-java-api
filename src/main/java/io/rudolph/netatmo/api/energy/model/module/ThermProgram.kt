package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.energy.model.Timetable
import io.rudolph.netatmo.api.energy.model.Zone

data class ThermProgram(
        @JsonProperty("zones")
        val zones: List<Zone> = listOf(),

        @JsonProperty("timetable")
        val timetable: List<Timetable> = listOf(),

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("program_id")
        val programId: String? = null,


        @JsonProperty("selected")
        val selected: Boolean = false
)
