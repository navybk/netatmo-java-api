package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AirQualityData(
        @JsonProperty("maxscale")
        val maxscale: Int,

        @JsonProperty("paramName")
        val paramName: String,

        @JsonProperty("source")
        val source: String,

        @JsonProperty("maxgauge")
        val maxgauge: Int,

        @JsonProperty("hash_url")
        val hash_url: String,

        @JsonProperty("airq_url")
        val airq_url: String,

        @JsonProperty("type")
        val type: List<AirQualityType>,

        @JsonProperty("data")
        val data: List<AirQualitySubData>
)