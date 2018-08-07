package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module


data class Home(
        @JsonProperty("id")
        val id: String,

        @JsonProperty("altitude")
        val altitude: String? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("country")
        val country: String? = null,

        @JsonProperty("timezone")
        val timezone: String? = null,

        @JsonProperty("therm_mode")
        val thermMode: ThermMode? = null,

        @JsonProperty("coordinates")
        val coordinates: Coordinates? = null,

        @JsonProperty("therm_setpoint_default_duration")
        val thermSetpointDefaultDuration: Long? = null,

        @JsonProperty("rooms")
        val rooms: List<Room> = listOf(),

        @JsonProperty("modules")
        val modules: List<Module> = listOf(),

        @JsonProperty("therm_schedules")
        val thermSchedules: List<Schedule> = listOf(),

        @JsonProperty("schedules")
        val schedules: List<Schedule> = listOf()
) {

    fun getRoomForModule(module: Module) =
            rooms?.find {
                it.moduleIds?.contains(module.id) ?: false
            }
}

