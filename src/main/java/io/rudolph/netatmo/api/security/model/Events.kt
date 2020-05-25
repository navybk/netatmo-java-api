package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.security.model.event.Event

data class Events(
        @JsonProperty("events_list")
        val eventsList: List<Event>? = null
)