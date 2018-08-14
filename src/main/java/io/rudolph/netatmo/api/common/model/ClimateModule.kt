package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.DashboardData
import java.time.LocalDateTime

data class ClimateModule(

        @JsonProperty("data_type")
        val dataType: List<String>? = null,

        @JsonProperty("last_setup")
        val lastSetup: LocalDateTime? = null,

        /**
     * Version of the software
     */
    @JsonProperty("firmware")
        val firmware: Int? = null,

        @JsonProperty("last_message")
        val lastMessage: LocalDateTime? = null,

        @JsonProperty("last_seen")
        val lastSeen: LocalDateTime? = null,

        @JsonProperty("battery_vp")
        val batteryVP: Int? = null,

        /**
     * Last data measured per device
     */
    @JsonProperty("dashboard_data")
    val dashboardData: DashboardData? = null
) : Module() {

    val getBatteryState: BatteryState
    get() {
        batteryVP?: return BatteryState.NO_DATA
        val map = when (type) {
            DeviceType.OUTDOORMODULE -> BatteryState.OUTDOOR
            DeviceType.RAINGAUGEMODULE -> BatteryState.RAINGAUGE
            DeviceType.INDOORMODULE -> BatteryState.INDOOR
            DeviceType.WINDMODULE -> BatteryState.WIND
            else -> return BatteryState.NO_DATA
        }
        map.keys.reversed().forEach {
                if (batteryVP >= it) {
                    return map.get(it)!!
                }
        }
        return BatteryState.VERYLOW
    }
}