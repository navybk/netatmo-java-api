package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Administrative(
        @JsonProperty("country")
        private val country: String? = null,

        @JsonProperty("unit")
        private val unit: String? = null,

        @JsonProperty("reg_locale")
        private val regLocale: String? = null,

        @JsonProperty("windunit")
        private val windunit: String? = null,

        @JsonProperty("feel_like_algo")
        private val feelLikeAlgo: String? = null,

        @JsonProperty("lang")
        private val lang: String? = null,

        @JsonProperty("pressureunit")
        private val pressureunit: String? = null
)