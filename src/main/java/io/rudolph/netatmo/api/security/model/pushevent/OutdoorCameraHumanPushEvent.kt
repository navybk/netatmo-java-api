package io.rudolph.netatmo.api.security.model.pushevent

import com.fasterxml.jackson.annotation.JsonProperty

class OutdoorCameraHumanPushEvent(
        @JsonProperty("vignette_id")
        val vignetteId: String,

        @JsonProperty("vignette_key")
        val vignetteKey: String,

        @JsonProperty("vignette_url")
        val vignetteUrl: String,

        @JsonProperty("subevent_id")
        val subeventId: String
) : CameraPicturePushEvent()