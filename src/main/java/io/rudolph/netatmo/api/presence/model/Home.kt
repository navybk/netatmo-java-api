package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Home(
        @JsonProperty("cameras")
        private val cameras: List<Camera>? = null,

        @JsonProperty("persons")
        private val persons: List<Person>? = null,

        @JsonProperty("name")
        private val name: String? = null,

        @JsonProperty("id")
        private val id: String? = null,

        @JsonProperty("place")
        private val place: Place? = null,

        @JsonProperty("events")
        private val events: List<Event>? = null,

        @JsonProperty("modules")
        private val modules: List<Module>? = null
)