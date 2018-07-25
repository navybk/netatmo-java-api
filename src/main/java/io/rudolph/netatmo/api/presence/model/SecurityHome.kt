package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * information about users homes and cameras.
 */
data class SecurityHome(
        @JsonProperty("global_info")
        private val globalInfo: GlobalInfo? = null,

        @JsonProperty("homes")
        private val homes: List<Home>? = null,

        @JsonProperty("user")
        private val user: User? = null
)