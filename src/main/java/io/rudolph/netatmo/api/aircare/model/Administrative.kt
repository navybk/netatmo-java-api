package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Administrative(
        @JsonProperty("country")
        val country: String? = null,

        @JsonProperty("unit")
        val unit: String? = null,

        @JsonProperty("reg_locale")
        val regLocale: String? = null,

        @JsonProperty("windunit")
        val windunit: String? = null,

        @JsonProperty("feel_like_algo")
        val feelLikeAlgo: String? = null,

        @JsonProperty("lang")
        val lang: String? = null,

        @JsonProperty("pressureunit")
        val pressureunit: String? = null
)