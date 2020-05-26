package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Place(
        @JsonProperty("altitude")
        val altitude: Float? = null,

        @JsonProperty("country")
        val country: String? = null,

        /**
         * Name of the city where the Thermostat is located
         */
        @JsonProperty("city")
        val city: String? = null,

        @JsonProperty("timezone")
        val timezone: String? = null,

        @JsonProperty("improveLocProposed")
        val improveLocProposed: Boolean? = null,

        /**
         * latitude and longitude
         */
        @JsonProperty("location")
        val location: List<LatLong> = listOf(),

        @JsonProperty("trust_location")
        val trustLocation: Boolean? = null,

        @JsonProperty("from_ip")
        val fromIp: Boolean? = null
)