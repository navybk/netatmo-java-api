package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Ping(
        @JsonProperty("local_url")
        var localUrl: String? = null,

        @JsonProperty("product_name")
        var productName: String? = null
)