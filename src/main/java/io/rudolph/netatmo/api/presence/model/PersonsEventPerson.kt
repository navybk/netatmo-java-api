package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonsEventPerson(
        @JsonProperty("id")
        val id: String,

        @JsonProperty("face_id")
        val faceId: String,

        @JsonProperty("face_key")
        val faceKey: String,

        @JsonProperty("is_known")
        val isKnown: Boolean = false
)