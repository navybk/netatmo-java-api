package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Module(
        @JsonProperty("last_activity")
        private val lastActivity: Int? = null,

        @JsonProperty("rf")
        private val rf: String? = null,

        @JsonProperty("battery_percent")
        private val batteryPercent: Int? = null,

        @JsonProperty("name")
        private val name: String? = null,

        @JsonProperty("id")
        private val id: String? = null,

        @JsonProperty("type")
        private val type: String? = null,

        @JsonProperty("status")
        private val status: String? = null
)