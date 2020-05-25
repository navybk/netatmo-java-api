package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonCameraEvent(
        @JsonProperty("person_id")
        val personId: String
) : CameraSnapshotEvent()