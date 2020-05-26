package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * Last data measured per device
 */
data class DashboardData(
        @JsonProperty("time_utc")
        val timeUtc: LocalDateTime? = null,

        @JsonProperty("Temperature")
        val temperature: Float? = null,

        @JsonProperty("Noise")
        val noise: Int? = null,

        @JsonProperty("CO2")
        val cO2: Int? = null,

        @JsonProperty("date_max_temp")
        val dateMaxTemp: Int? = null,

        @JsonProperty("Rain")
        val rain: Int? = null,

        @JsonProperty("BoilerOn")
        val boilerOn: Int? = null,

        @JsonProperty("min_temp")
        val minTemp: Float? = null,

        @JsonProperty("Humidity")
        val humidity: Int? = null,

        @JsonProperty("max_temp")
        val maxTemp: Float? = null,

        @JsonProperty("sum_rain_24")
        val sumRain24: Int? = null,

        @JsonProperty("sum_rain_1")
        val sumRain1: Int? = null,

        @JsonProperty("WindStrength")
        val windStrength: Int? = null,

        @JsonProperty("date_min_temp")
        val dateMinTemp: Int? = null,

        @JsonProperty("date_max_wind_str")
        val dateMaxWindStr: Int? = null,

        @JsonProperty("device_id")
        val deviceId: Int? = null,

        @JsonProperty("pressure_trend")
        val pressureTrend: String? = null,

        @JsonProperty("temp_trend")
        val tempTrend: String? = null,

        @JsonProperty("Pressure")
        val pressure: Float? = null,

        @JsonProperty("GustAngle")
        val gustAngle: Int? = null,

        @JsonProperty("max_wind_str")
        val maxWindStrength: Int? = null,

        @JsonProperty("max_wind_angle")
        val maxWindAngle: Int? = null,

        @JsonProperty("BoilerOff")
        val boilerOff: Int? = null,

        @JsonProperty("GustStrength")
        val gustStrength: Int? = null,

        @JsonProperty("health_idx")
        val healthIdx: Int? = null,

        @JsonProperty("AbsolutePressure")
        val absolutePressure: Float? = null,

        @JsonProperty("WindAngle")
        val windAngle: Int? = null
)