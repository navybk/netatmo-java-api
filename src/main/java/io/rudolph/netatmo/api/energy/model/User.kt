package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class User(
        @JsonProperty("id")
        var id: String? = null,

        @JsonProperty("email")
        var email: String? = null,

        @JsonProperty("language")
        var language: String? = null,

        @JsonProperty("locale")
        var locale: String? = null,

        @JsonProperty("feel_like_algorithm")
        var feelLikeAlgorithm: Long? = null,

        @JsonProperty("unit_pressure")
        var unitPressure: Long? = null,

        @JsonProperty("unit_system")
        var unitSystem: Long? = null,

        @JsonProperty("unit_wind")
        var unitWind: Long? = null
)