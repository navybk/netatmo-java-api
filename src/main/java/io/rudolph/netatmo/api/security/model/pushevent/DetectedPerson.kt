package io.rudolph.netatmo.api.security.model.pushevent

import com.fasterxml.jackson.annotation.JsonProperty

data class DetectedPerson(
        @JsonProperty("id")
        val id: String,

        @JsonProperty("face_id")
        val faceId: String,

        @JsonProperty("face_key")
        val faceKey: String,

        @JsonProperty("is_known")
        val isKnown: Boolean,

        @JsonProperty("face_url")
        val faceUrl: String
)