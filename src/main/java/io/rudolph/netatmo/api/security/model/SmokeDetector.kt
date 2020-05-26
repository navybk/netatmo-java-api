package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime

data class SmokeDetector(
        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("type")
        val type: DeviceType,

        @JsonProperty("last_setup")
        val lastSetup: LocalDateTime? = null,

        @JsonProperty("name")
        val name: String
)