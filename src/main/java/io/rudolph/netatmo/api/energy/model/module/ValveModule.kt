package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty

data class ValveModule(
        @JsonProperty("id")
        override val id: String? = null
) : ValveBaseModule()