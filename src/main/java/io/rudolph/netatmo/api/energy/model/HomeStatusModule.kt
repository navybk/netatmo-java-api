package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.misc.model.DeviceType

/**
 * Module status definition
 */
data class HomeStatusModule(
        /**
         * module id
         */
        @JsonProperty("id")
        var id: String? = null,

        /**
         * NATherm1 = thermostat
         * NRV = valve
         * NAPlug = relay
         * NACamera = welcome camera
         * NOC = presence camera
         */
        @JsonProperty("type")
        var type: DeviceType? = null,

        /**
         * 90 = low
         * 80 = medium
         * 70 = high
         * 60 = full signal
         */
        @JsonProperty("rf_strength")
        var rfStrength: Int? = null,

        /**
         * Battery level
         */
        @JsonProperty("battery_level")
        var batteryLevel: Int? = null,


        /**
         * id of Bridge
         */
        @JsonProperty("bridge")
        var bridge: String? = null,

        /**
         * human readable battery state
         */
        @JsonProperty("battery_state")
        var batteryState: String? = null,

        /**
         * 56 good
         * 86 poor
         */
        @JsonProperty("wifi_strength")
        var wifiStrength: Int? = null,

        /**
         * The module can communicate with the relay
         */
        @JsonProperty("reachable")
        var isReachable: Boolean? = null,

        /**
         * Version of the firmware
         */
        @JsonProperty("firmware_revision")
        var firmwareRevision: Int? = null,

        /**
         * Only for NAPlug
         */
        @JsonProperty("connected_to_boiler")
        var connectedToBoiler: Boolean? = false,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_status")
        var boilerStatus: String? = null,

        /**
         * Only for NATherm1 Indicate whether or not a valve is currently asking for a boiler Boost
         */
        @JsonProperty("boiler_valve_comfort_boost")
        var boileValveComfortBoost: String? = null,

        /**
         * Only for valve type Number displayed during the pairing with the relay
         */
        @JsonProperty("radio_id")
        var radioId: String? = null,


        /**
         * The module is currently heating to anticipate a schedule temperature
         */
        @JsonProperty("anticipating")
        var anticipation: Boolean? = false
)
