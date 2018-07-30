package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module


data class HomestatusBodyHome(
        @JsonProperty("modules")
        var modules: List<Module>? = null,

        @JsonProperty("rooms")
        var rooms: List<HomeStatusRoom>? = null,

        @JsonProperty("id")
        var id: String? = null
)
