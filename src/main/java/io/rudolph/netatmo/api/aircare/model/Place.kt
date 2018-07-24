package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Place(
        @JsonProperty("altitude")
        private val altitude: Int? = null,

        @JsonProperty("country")
        private val country: String? = null,

        /**
         * Name of the city where the Thermostat is located
         */
        @JsonProperty("city")
        private val city: String? = null,

        @JsonProperty("timezone")
        private val timezone: String? = null,

        @JsonProperty("improveLocProposed")
        private val improveLocProposed: Boolean? = null,

        /**
         * latitude and longitude
         */
        @JsonProperty("location")
        private val location: List<Float>? = null,

        @JsonProperty("trust_location")
        private val trustLocation: Boolean? = null,

        @JsonProperty("from_ip")
        private val fromIp: Boolean? = null
)