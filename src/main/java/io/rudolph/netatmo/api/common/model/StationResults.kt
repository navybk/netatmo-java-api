package io.rudolph.netatmo.api.common.model


import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.User


data class StationResults(
        @JsonProperty("devices")
        val devices: List<Device> = listOf(),

        /**
         * User related information
         */
        @JsonProperty("user")
        val user: User
)