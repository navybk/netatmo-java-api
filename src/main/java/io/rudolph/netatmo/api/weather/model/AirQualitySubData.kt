package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class AirQualitySubData(

        @JsonProperty("beg_time")
        val beg_time: LocalDateTime,

        @JsonProperty("value")
        val value: List<List<String>>

)
