package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.BatteryState
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class ValveModule(
        @JsonProperty("id")
        override val id: String? = null,

        @JsonProperty("room_id")
        override val roomId: String? = null,

        /**
         * id of Bridge
         */
        @JsonProperty("bridge")
        override val bridgeId: String? = null,

        /**
         * Battery level
         */
        @JsonAlias("battery_level")
        override val batteryLevel: Int? = null,

        /**
         * human readable battery state
         */
        @JsonProperty("battery_state")
        override val batteryState: BatteryState? = BatteryState.NO_DATA,

        /**
         * Version of the firmware
         */
        @JsonProperty("firmware_revision")
        override val firmware: Int? = null,

        /**
         * False if none of the module of the room are reachable
         */
        @JsonProperty("reachable")
        override val isReachable: Boolean? = null,

        @JsonProperty("setup_date")
        override val setupDate: LocalDateTime? = null,

        /**
         * 90 = low
         * 80 = medium
         * 70 = high
         * 60 = full signal
         */
        @JsonProperty("rf_status")
        @JsonAlias("rf_strength")
        override val rfStrength: Int? = null,

        /**
         * Module Name
         */
        @JsonAlias("name")
        override val moduleName: String? = null,

        @JsonAlias("type")
        override val type: DeviceType = DeviceType.VALVE
) : ValveBaseModule<ValveModule>() {

    override fun join(module: ValveModule): ValveModule =
            copy(rfStrength = rfStrength ?: module.rfStrength,
                    moduleName = moduleName ?: module.moduleName,
                    setupDate = setupDate ?: module.setupDate,
                    batteryLevel = batteryLevel ?: module.batteryLevel,
                    batteryState = batteryState ?: module.batteryState,
                    bridgeId = bridgeId ?: module.bridgeId,
                    firmware = firmware ?: module.firmware,
                    isReachable = isReachable ?: module.isReachable,
                    roomId = roomId ?: module.roomId)

}