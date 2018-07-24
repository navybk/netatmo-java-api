package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty


data class DateCreation(
        @JsonProperty("sec")
        private val sec: Int? = null,

        @JsonProperty("usec")
        private val usec: Int? = null
)