package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

abstract class ValveBaseModule : EnergyModule() {
    @JsonProperty("room_id")
    val roomId: String? = null

    /**
     * id of Bridge
     */
    @JsonProperty("bridge")
    val bridgeId: String? = null

    /**
     * Battery level
     */
    @JsonAlias("battery_level", "battery_percent")
    val batteryLevel: Int? = null

    /**
     * human readable battery state
     */
    @JsonProperty("battery_state")
    val batteryState: String? = null

    /**
     * Version of the firmware
     */
    @JsonProperty("firmware_revision")
    val firmwareRevision: Int? = null

    /**
     * False if none of the module of the room are reachable
     */
    @JsonProperty("reachable")
    val isReachable: Boolean? = null

    /**
     * The module is currently heating to anticipate a schedule temperature
     */
    @JsonProperty("anticipating")
    val anticipation: Boolean? = false
}