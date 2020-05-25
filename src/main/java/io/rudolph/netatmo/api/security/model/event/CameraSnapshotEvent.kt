package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.security.model.Snapshot

open class CameraSnapshotEvent: CameraEvent() {
    val snapshot: Snapshot? = null

    @JsonProperty("video_id")
    val videoId: String? = null

    @JsonProperty("video_status")
    val videoStatus: String? = null
}