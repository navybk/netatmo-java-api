package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.BatteryState
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime

abstract class ValveBaseModule<T> constructor(
        @JsonProperty("room_id")
        open val roomId: String? = null,

        /**
         * id of Bridge
         */
        @JsonProperty("bridge")
        open val bridgeId: String? = null,

        /**
         * Battery level
         */
        @JsonAlias("battery_level", "battery_vp")
        open val batteryLevel: Int? = null,

        /**
         * human readable battery state
         */
        @JsonProperty("battery_state")
        open val batteryState: BatteryState? = BatteryState.NO_DATA,

        /**
         * Version of the firmware
         */
        @JsonProperty("firmware_revision")
        open val firmware: Int? = null,

        /**
         * False if none of the module of the room are reachable
         */
        @JsonProperty("reachable")
        open val isReachable: Boolean? = null,

        /**
         * The module is currently heating to anticipate a schedule temperature
         */
        @JsonProperty("anticipating")
        open val anticipation: Boolean? = false,

        @JsonProperty("setup_date")
        override val setupDate: LocalDateTime? = null,

        /**
         * 56 good
         * 86 poor
         */
        @JsonProperty("wifi_strength")
        override val wifiStrength: Int? = null,

        @JsonAlias("id", "_id")
        override val id: String? = null,

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
         * Battery level
         */
        @JsonProperty("battery_percent")
        override val batteryLevelInPercent: Int? = null,

        /**
         * Module Name
         */
        @JsonAlias("module_name", "name")
        override val moduleName: String? = null,

        @JsonAlias("type")
        override val type: DeviceType = DeviceType.UNKNOWN
) : EnergyModule<T>()