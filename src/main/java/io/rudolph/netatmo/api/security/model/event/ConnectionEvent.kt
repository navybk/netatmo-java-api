package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.JsonProperty

data class ConnectionEvent(
        @JsonProperty("sub_type")
        val subType: Int
) : CameraEvent()