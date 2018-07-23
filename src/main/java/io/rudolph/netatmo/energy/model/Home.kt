package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Home(
        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("altitude")
        var altitude: String? = null,

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("country")
        var country: String? = null,

        @JsonProperty("timezone")
        var timezone: String? = null,

        @JsonProperty("therm_mode")
        var thermMode: ThermMode? = null,

        @JsonProperty("coordinates")
        var coordinates: Coordinates? = null,

        @JsonProperty("therm_setpoint_default_duration")
        var thermSetpointDefaultDuration: Long? = null,

        @JsonProperty("rooms")
        var rooms: List<Room>? = null,

        @JsonProperty("modules")
        var modules: List<Module>? = null,

        @JsonProperty("therm_schedules")
        var thermSchedules: List<ThermSchedule>? = null,

        @JsonProperty("schedules")
        var schedules: List<Schedule>? = null
)

