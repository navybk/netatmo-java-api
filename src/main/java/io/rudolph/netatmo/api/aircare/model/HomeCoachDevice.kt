package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Device
import io.rudolph.netatmo.api.common.model.DeviceType

data class HomeCoachDevice(
        @JsonProperty("type")
        override val type: DeviceType = DeviceType.HOMECOACH
): Device()