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
        val time_day_begin: LocalDateTime,

        @JsonProperty("time_day_end")
        val time_day_end: LocalDateTime,

        @JsonProperty("last_time_ask")
        val last_time_ask: LocalDateTime,

        @JsonProperty("cityname")
        val cityname: String,

        @JsonProperty("current_symbol")
        val current_symbol: String,

        @JsonProperty("current_windgust")
        val current_windgust: Int,

        @JsonProperty("current_windstrength")
        val current_windstrength: String,

        @JsonProperty("time_current")
        val time_current: LocalDateTime,

        @JsonProperty("time_current_symbol")
        val time_current_symbol: Int,

        @JsonProperty("stationname")
        val stationname: String,

        @JsonProperty("from_cache")
        val from_cache: Boolean,

        @JsonProperty("current_temp")
        val currentTemperature: Float,

        @JsonProperty("current_temp_time")
        val current_temp_time: LocalDateTime

)