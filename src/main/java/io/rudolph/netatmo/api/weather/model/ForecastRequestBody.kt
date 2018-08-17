package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ForecastRequestBody(
        @JsonProperty("device_id")
        val devideId: String,

        @JsonProperty("module_id")
        val moduleId: String? = null,

        @JsonProperty("app_version")
        val appVersion: String? = "2.4.5."
)