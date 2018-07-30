package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty

abstract class ValveBaseModule: EnergyModule () {
    @JsonProperty("room_id")
    var roomId: String? = null

    /**
     * id of Bridge
     */
    @JsonProperty("bridge")
    var bridgeId: String? = null

    /**
     * Battery level
     */
    @JsonProperty("battery_level")
    var batteryLevel: Int? = null

    /**
     * human readable battery state
     */
    @JsonProperty("battery_state")
    var batteryState: String? = null

    /**
     * Version of the firmware
     */
    @JsonProperty("firmware_revision")
    var firmwareRevision: Int? = null

    /**
     * False if none of the module of the room are reachable
     */
    @JsonProperty("reachable")
    var isReachable: Boolean? = null

    /**
     * The module is currently heating to anticipate a schedule temperature
     */
    @JsonProperty("anticipating")
    var anticipation: Boolean? = false
}