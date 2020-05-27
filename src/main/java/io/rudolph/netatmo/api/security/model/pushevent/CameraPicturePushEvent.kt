package io.rudolph.netatmo.api.security.model.pushevent

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

abstract class CameraPicturePushEvent(
        @JsonProperty("snapshot_id")
        @field:JsonAlias("snapshot_id")
        @param:JsonAlias("snapshot_id")
        val snapshotId: String = "",

        @JsonProperty("snapshot_key")
        @field:JsonAlias("snapshot_key")
        @param:JsonAlias("snapshot_key")
        val snapshotKey: String = "",

        @JsonProperty("snapshot_url")
        @field:JsonAlias("snapshot_url")
        @param:JsonAlias("snapshot_url")
        val snapshotUrl: String = ""
) : PushEvent()