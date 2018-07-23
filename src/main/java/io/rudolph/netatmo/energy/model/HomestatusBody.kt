package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomestatusBody(
        @JsonProperty("home")
        var home: HomestatusBodyHome? = null
)


