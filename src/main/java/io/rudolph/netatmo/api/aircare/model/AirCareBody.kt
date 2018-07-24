package io.rudolph.netatmo.api.aircare.model


import apiresults.aircare.DevicesItem
import com.fasterxml.jackson.annotation.JsonProperty


data class AirCareBody(
        @JsonProperty("devices")
        private val devices: List<DevicesItem>? = null,

        @JsonProperty("user")
        private val user: User? = null
)