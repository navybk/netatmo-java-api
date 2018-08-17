package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class RelayModule(
        @JsonProperty("id")
        override val id: String? = null,

        @JsonProperty("modules_bridged")
        val modulesBridged: List<String>? = null,

        /**
         * Only for NAPlug
         */
        @JsonProperty("connected_to_boiler")
        val connectedToBoiler: Boolean? = false,

        /**
         * Module Name
         */
        @JsonAlias("name")
        override val moduleName: String? = null,

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
         * 56 good
         * 86 poor
         */
        @JsonProperty("wifi_strength")
        override val wifiStrength: Int? = null,

        @JsonAlias("type")
        override val type: DeviceType = DeviceType.RELAY
) : EnergyModule<RelayModule>() {

    override fun join(module: RelayModule): RelayModule =
            RelayModule(id = id ?: module.id,
                    wifiStrength = wifiStrength ?: module.wifiStrength,
                    setupDate = setupDate ?: module.setupDate,
                    connectedToBoiler = connectedToBoiler ?: module.connectedToBoiler,
                    moduleName = moduleName ?: module.moduleName,
                    rfStrength = rfStrength ?: module.rfStrength,
                    type = type,
                    modulesBridged = modulesBridged ?: module.modulesBridged)

}