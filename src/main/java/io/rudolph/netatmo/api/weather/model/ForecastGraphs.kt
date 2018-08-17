package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ForecastGraphs(
        @JsonProperty("rain")
        val rain: List<DataPoint<Int>>? = null,

        @JsonProperty("rain_proba")
        val rainProba: List<DataPoint<Int>>? = null,

        @JsonProperty("temperature")
        val temperature: List<DataPoint<Float>>? = null,

        @JsonProperty("humidity")
        val humidity: List<DataPoint<Float>>? = null
)