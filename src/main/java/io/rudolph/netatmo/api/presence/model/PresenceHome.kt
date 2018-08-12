package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.Place


data class PresenceHome(
        @JsonProperty("cameras")
        val cameras: List<Camera>? = null,

        @JsonProperty("persons")
        val persons: List<Person>? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("place")
        val place: Place? = null,

        @JsonProperty("events")
        val events: List<Event>? = null,

        @JsonProperty("modules")
        val modules: List<PresenceModule>? = null
)