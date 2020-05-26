package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.Place
import io.rudolph.netatmo.api.security.model.event.Event

@JsonIgnoreProperties(ignoreUnknown = true)
data class SecurityHome(
        @JsonProperty("camera")
        val cameras: List<Camera>? = null,

        @JsonProperty("person")
        val persons: List<Person>? = null,

        @JsonProperty("smokedetectors")
        val smokeDetectors: List<SmokeDetector>,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("place")
        val place: Place? = null,

        @JsonProperty("events")
        val events: List<Event>? = null
)