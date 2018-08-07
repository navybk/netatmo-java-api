package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty


data class DateCreation(
        @JsonProperty("sec")
        val sec: Int? = null,

        @JsonProperty("usec")
        val usec: Int? = null
)