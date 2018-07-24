package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class BaseOutdoorMeasure(
        @JsonProperty("res")
        val res: MutableMap<LocalDateTime, MutableList<Float>>? = mutableMapOf(),

        @JsonProperty("type")
        val type: MutableList<String> = mutableListOf()
) : Measure