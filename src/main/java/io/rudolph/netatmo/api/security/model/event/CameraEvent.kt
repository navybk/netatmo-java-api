package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.JsonProperty

abstract class CameraEvent(
        /**
         * Camera that detected the event
         */
        @JsonProperty("camera_id")
        val cameraId: String? = null,

        /**
         * TODO: evaluate purpose
         */
        @JsonProperty("device_id")
        val deviceId: String? = null
) : Event()