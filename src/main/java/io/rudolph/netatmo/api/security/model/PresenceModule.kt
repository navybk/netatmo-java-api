package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module
import java.time.LocalDateTime


data class PresenceModule(
        @JsonProperty("last_activity")
        val lastActivity: LocalDateTime? = null,

        @JsonProperty("status")
        val status: String? = null
) : Module()