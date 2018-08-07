package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty

data class SetPoint(
        @JsonProperty("setpoint_mode")
        val setPointMode: String
)