package io.rudolph.netatmo.api.security.model.pushevent

import com.fasterxml.jackson.annotation.JsonProperty

data class SmokeAlarmPushEvent(
        @JsonProperty("sub_type")
        val subType: Int
) : PushEvent()