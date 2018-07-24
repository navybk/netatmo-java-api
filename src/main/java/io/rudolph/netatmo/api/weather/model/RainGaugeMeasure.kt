package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class RainGaugeMeasure(
        @JsonProperty("rain_60min")
        val rainHourMin: Float,

        @JsonProperty("rain_24h")
        val rainDay: Float,

        @JsonProperty("rain_live")
        val rainLive: Float,

        @JsonProperty("rain_timeutc")
        val rainTimeUTC: LocalDateTime
) : Measure