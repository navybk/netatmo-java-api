package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Device
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime


data class RelayDevice(

        @JsonProperty("last_bilan")
        val lastBilan: LastBilan,


        @JsonProperty("plug_connected_boiler")
        val plugConnectedBoiler: Int,

        @JsonProperty("udp_conn")
        val udpConn: Boolean,


        @JsonProperty("last_plug_seen")
        val lastPlugSeen: LocalDateTime
) : Device() {
    override val type: DeviceType = DeviceType.THERMOSTAT
}