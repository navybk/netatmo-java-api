package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class MeasureRequestResponse(
        @JsonProperty("beg_time")
        val begTime: LocalDateTime,

        @JsonProperty("step_time")
        val stepTime: LocalDateTime,

        @JsonProperty("value")
        val value: MutableList<MutableList<Float>>?= mutableListOf<MutableList<Float>>()
)