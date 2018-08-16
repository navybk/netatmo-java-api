package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class ForecastDay(
        @JsonProperty("day_locale")
        val dayReadable: String,

        @JsonProperty("day_ts")
        val dayDateTime: LocalDateTime,

        @JsonProperty("min_temp")
        val min_temp: Int,

        @JsonProperty("max_temp")
        val maxTemp: Int,

        @JsonProperty("sunset")
        val sunset: LocalDateTime,

        @JsonProperty("sunrise")
        val sunrise: LocalDateTime,

        @JsonProperty("sun")
        val sunshineHours: Float,

        @JsonProperty("rain")
        val rainInMillimeter: Float,

        @JsonProperty("uv")
        val uvIndex: String,

        @JsonProperty("windgust")
        val windgust: Int,

        @JsonProperty("windangle")
        val windangle: Int,

        @JsonProperty("wind_direction")
        val windDirection: Int,

        // TODO: parse to Enum
        @JsonProperty("weather_symbol_night")
        val weather_symbol_night: Int,

        // TODO: parse to Enum
        @JsonProperty("weather_symbol_day")
        val weatherSymbolDay: Int
)