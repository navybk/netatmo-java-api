package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Ping(
        @JsonProperty("local_url")
        val localUrl: String? = null,

        @JsonProperty("product_name")
        val productName: String? = null
)