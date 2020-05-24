package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module


data class HomesDataBody(
        @JsonProperty("homes")
        val homes: List<Home> = listOf(),

        @JsonProperty("user")
        val user: User? = null,

        @JsonProperty("modules")
        val modules: List<Module> = listOf()
)

