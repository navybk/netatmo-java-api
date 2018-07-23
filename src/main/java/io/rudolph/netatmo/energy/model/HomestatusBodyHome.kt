package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomestatusBodyHome(
        @JsonProperty("modules")
        var modules: List<HomeStatusModule>? = null,

        @JsonProperty("rooms")
        var rooms: List<Homestatusroom>? = null,

        @JsonProperty("id")
        var id: String? = null
)
