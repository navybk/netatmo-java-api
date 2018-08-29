package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomeStatusBody(
        @JsonProperty("home")
        val homes: List<HomestatusBodyHome> = listOf()
)


