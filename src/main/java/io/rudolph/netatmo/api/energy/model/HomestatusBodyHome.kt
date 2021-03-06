package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module


data class HomestatusBodyHome(
        @JsonProperty("modules")
        val modules: List<Module> = listOf(),

        @JsonProperty("rooms")
        val rooms: List<Room> = listOf(),

        @JsonProperty("id")
        val id: String? = null
)
