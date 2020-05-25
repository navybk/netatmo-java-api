package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.security.model.Snapshot

data class MovementCameraEvent(
        @JsonProperty("vignette")
        val vignette: Snapshot
) : CameraSnapshotEvent()