package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomestatusBodyHome(
        @JsonProperty("modules")
        var modules: List<HomeStatusModule>? = null,

        @JsonProperty("rooms")
        var rooms: List<HomeStatusRoom>? = null,

        @JsonProperty("id")
        var id: String? = null
)
