package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ForecastGraphs(
        @JsonProperty("rain")
        val rain: List<Pair<LocalDateTime, Int>>? = null,

        @JsonProperty("rain_proba")
        val rainProba: List<Pair<LocalDateTime, Int>>? = null,

        @JsonProperty("temperature")
        val temperature: List<Pair<LocalDateTime, Int>>? = null,

        @JsonProperty("humidity")
        val humidity: List<Pair<LocalDateTime, Int>>? = null
)