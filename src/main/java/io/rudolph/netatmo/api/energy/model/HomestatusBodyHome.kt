package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module


data class HomestatusBodyHome(
        @JsonProperty("modules")
        val modules: List<Module>? = null,

        @JsonProperty("rooms")
        val rooms: List<HomeStatusRoom>? = null,

        @JsonProperty("id")
        val id: String? = null
)
