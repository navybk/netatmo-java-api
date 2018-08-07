package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomesDataBody(
        @JsonProperty("homes")
        val homes: List<Home> = listOf(),

        @JsonProperty("user")
        val user: User? = null
)

