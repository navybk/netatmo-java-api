package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("email")
        val email: String? = null,

        @JsonProperty("language")
        val language: String? = null,

        @JsonProperty("locale")
        val locale: String? = null,

        @JsonProperty("feel_like_algorithm")
        val feelLikeAlgorithm: Long? = null,

        @JsonProperty("unit_pressure")
        val unitPressure: Long? = null,

        @JsonProperty("unit_system")
        val unitSystem: Long? = null,

        @JsonProperty("unit_wind")
        val unitWind: Long? = null
)