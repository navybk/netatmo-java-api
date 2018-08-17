package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Forecast(
        @JsonProperty("forecastDays")
        val forecastDays: List<ForecastDay>? = listOf(),

        @JsonProperty("forecastGraphs")
        val forecastGraphs: ForecastGraphs,

        @JsonProperty("airqdata")
        val airqdata: AirQualityData,

        @JsonProperty("time_day_begin")
        val timeDayBegin: LocalDateTime,

        @JsonProperty("time_day_end")
        val timeDayEnd: LocalDateTime,

        @JsonProperty("last_time_ask")
        val lastTimeAsk: LocalDateTime,

        @JsonProperty("cityname")
        val cityname: String,

        @JsonProperty("current_symbol")
        val currentSymbol: String,

        @JsonProperty("current_windgust")
        val currentWindgust: Int,

        @JsonProperty("current_windstrength")
        val currentWindstrength: String,

        @JsonProperty("time_current")
        val currentTime: LocalDateTime,

        @JsonProperty("time_current_symbol")
        val currentTimeSymbol: Int,

        @JsonProperty("stationname")
        val stationname: String,

        @JsonProperty("from_cache")
        val fromCache: Boolean,

        @JsonProperty("current_temp")
        val currentTemperature: Float,

        @JsonProperty("current_temp_time")
        val currentTempTime: LocalDateTime

)