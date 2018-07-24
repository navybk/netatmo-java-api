package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


data class Module(
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

        @JsonProperty("name")
        var name: String? = null,

        @JsonProperty("setup_date")
        var setupDate: LocalDateTime? = null,

        @JsonProperty("modules_bridged")
        var modulesBridged: List<String>? = null,

        @JsonProperty("room_id")
        var roomId: String? = null,

        @JsonProperty("bridge")
        var bridge: String? = null
)

