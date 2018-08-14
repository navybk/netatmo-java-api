package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.common.model.Module
import io.rudolph.netatmo.api.common.model.WifiLevel
import java.time.LocalDateTime

abstract class EnergyModule <T> internal constructor(

        @JsonProperty("setup_date")
        open val setupDate: LocalDateTime? = null,

        /**
         * 56 good
         * 86 poor
         */
        @JsonProperty("wifi_strength")
        open val wifiStrength: Int? = null,

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
) : Module() {

    val wifiLevel: WifiLevel
        get() = WifiLevel.wifiLevelForSignalStrength(wifiStrength)

    abstract fun join(module: T): T
}