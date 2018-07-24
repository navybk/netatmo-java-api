package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class WindMeasure(
        @JsonProperty("wind_strength")
        val windStrength: Float,

        @JsonProperty("wind_angle")
        val windAngle: Float,

        @JsonProperty("gust_strength")
        val gustStrength: Float,

        @JsonProperty("gust_angle")
        val gustSngle: Float,

        @JsonProperty("wind_timeutc")
        val windTimeUTC: LocalDateTime

) : Measure