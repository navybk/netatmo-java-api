package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * information about users homes and cameras.
 */
data class SecurityHomeData(
        @JsonProperty("global_info")
        val globalInfo: GlobalInfo? = null,

        @JsonProperty("homes")
        val homes: List<SecurityHome>? = null,

        @JsonProperty("user")
        val user: User? = null
)