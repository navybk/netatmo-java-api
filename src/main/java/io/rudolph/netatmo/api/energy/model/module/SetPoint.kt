package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class SetPoint(
        @JsonProperty("setpoint_mode")
        val setPointMode: String,

        @JsonProperty("setpoint_endtime")
        val setPointEndTime: LocalDateTime? = null,

        @JsonProperty("setpoint_temp")
        val setpointTemp: Float? = null
)