package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AirQualityType(

        @JsonProperty("type_idx")
        val type_idx: String,

        @JsonProperty("data")
        val data: List<String> = listOf()
)