package io.rudolph.netatmo.api.aircare.model


import com.fasterxml.jackson.annotation.JsonProperty


data class AirCareBody(
        @JsonProperty("devices")
        private val devices: List<Device>? = null,

        /**
         * User related information
         */
        @JsonProperty("user")
        private val user: User? = null
)