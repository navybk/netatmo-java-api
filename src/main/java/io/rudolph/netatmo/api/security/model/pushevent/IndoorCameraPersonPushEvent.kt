package io.rudolph.netatmo.api.security.model.pushevent

import io.rudolph.netatmo.api.security.model.Person

data class IndoorCameraPersonPushEvent(
        val persons: List<DetectedPerson>

) : CameraPicturePushEvent()