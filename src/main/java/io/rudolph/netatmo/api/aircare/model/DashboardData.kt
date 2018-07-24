package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Last data measured per device
 */
data class DashboardData(
        @JsonProperty("time_utc")
        private val timeUtc: Int? = null,

        @JsonProperty("Temperature")
        private val temperature: Int? = null,

        @JsonProperty("Noise")
        private val noise: Int? = null,

        @JsonProperty("CO2")
        private val cO2: Int? = null,

        @JsonProperty("date_max_temp")
        private val dateMaxTemp: Int? = null,

        @JsonProperty("Rain")
        private val rain: Int? = null,

        @JsonProperty("BoilerOn")
        private val boilerOn: Int? = null,

        @JsonProperty("min_temp")
        private val minTemp: Int? = null,

        @JsonProperty("Humidity")
        private val humidity: Int? = null,

        @JsonProperty("max_temp")
        private val maxTemp: Int? = null,

        @JsonProperty("sum_rain_24")
        private val sumRain24: Int? = null,

        @JsonProperty("sum_rain_1")
        private val sumRain1: Int? = null,

        @JsonProperty("WindStrength")
        private val windStrength: Int? = null,

        @JsonProperty("date_min_temp")
        private val dateMinTemp: Int? = null,

        @JsonProperty("date_max_wind_str")
        private val dateMaxWindStr: Int? = null,

        @JsonProperty("device_id")
        private val deviceId: Int? = null,

        @JsonProperty("pressure_trend")
        private val pressureTrend: String? = null,

        @JsonProperty("temp_trend")
        private val tempTrend: String? = null,

        @JsonProperty("Pressure")
        private val pressure: Int? = null,

        @JsonProperty("GustAngle")
        private val gustAngle: Int? = null,

        @JsonProperty("max_wind_str")
        private val maxWindStr: Int? = null,

        @JsonProperty("BoilerOff")
        private val boilerOff: Int? = null,

        @JsonProperty("GustStrength")
        private val gustStrength: Int? = null,

        @JsonProperty("health_idx")
        private val healthIdx: Int? = null,

        @JsonProperty("AbsolutePressure")
        private val absolutePressure: Int? = null,

        @JsonProperty("WindAngle")
        private val windAngle: Int? = null
)