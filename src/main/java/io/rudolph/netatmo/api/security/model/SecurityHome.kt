package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * information about users homes and cameras.
 */
data class SecurityHome(
        @JsonProperty("global_info")
        val globalInfo: GlobalInfo? = null,

        @JsonProperty("homes")
        val homes: List<PresenceHome>? = null,

        @JsonProperty("user")
        val user: User? = null
)