package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class HomesDataBody(
        @JsonProperty("homes")
        var homes: List<Home>? = null,

        @JsonProperty("user")
        var user: User? = null
)

