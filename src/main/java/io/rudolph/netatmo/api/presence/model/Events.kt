package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Events(
        @JsonProperty("events_list")
        val eventsList: List<Event>? = null
)