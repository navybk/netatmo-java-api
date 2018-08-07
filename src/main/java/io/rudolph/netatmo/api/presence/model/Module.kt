package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


data class Module(
        @JsonProperty("last_activity")
        val lastActivity: LocalDateTime? = null,

        @JsonProperty("rf")
        val rf: String? = null,

        @JsonProperty("battery_percent")
        val batteryPercent: Int? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("type")
        val type: String? = null,

        @JsonProperty("status")
        val status: String? = null
)