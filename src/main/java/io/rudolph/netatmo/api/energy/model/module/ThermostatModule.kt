package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime

data class ThermostatModule(

        @field:JsonAlias("id", "_id")
        override val id: String,

        @JsonProperty("modules_bridged")
        val modulesBridged: List<String>? = null,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_status")
        val boilerStatus: String? = null,

        /**
         * Only for NATherm1
         */
        @JsonProperty("boiler_valve_comfort_boost")
        val boilerValveComfortBoost: String? = null,

        @JsonProperty("setpoint")
        val setPoint: SetPoint? = null,

        @JsonProperty("therm_program_list")
        val thermProgramList: List<ThermProgram> = listOf(),

        @JsonProperty("measured")
        val measure: Measure? = null,

        @JsonProperty("firmware_revision")
        @field:JsonAlias("firmware")
        override val firmware: Int? = null,

        @field:JsonAlias("last_seen", "last_therm_seen")
        val lastSeen: LocalDateTime? = null,

        @JsonProperty("last_message")
        val lastMessage: LocalDateTime? = null,

        @JsonProperty("therm_orientation")
        val thermOrientation: Int? = null,

        @JsonProperty("therm_relay_cmd")
        val thermRelayCmd: Int? = null,

        @JsonProperty("setup_date")
        override val setupDate: LocalDateTime? = null,

        @JsonProperty("room_id")
        override val roomId: String? = null,

        /**
         * 90 = low
         * 80 = medium
         * 70 = high
         * 60 = full signal
         */
        @JsonProperty("rf_status")
        @field:JsonAlias("rf_strength")
        override val rfStrength: Int? = null,

        @field:JsonAlias("type")
        override val type: DeviceType = DeviceType.THERMOSTAT
) : ValveBaseModule<ThermostatModule>(id = id) {

    override fun join(module: ThermostatModule): ThermostatModule =
            copy(modulesBridged = modulesBridged ?: module.modulesBridged,
                    boilerStatus = boilerStatus ?: module.boilerStatus,
                    boilerValveComfortBoost = boilerValveComfortBoost ?: module.boilerValveComfortBoost,
                    setPoint = setPoint ?: module.setPoint,
                    thermProgramList = if (thermProgramList.isEmpty()) thermProgramList else module.thermProgramList,
                    measure = measure ?: module.measure,
                    firmware = firmware ?: module.firmware,
                    lastSeen = lastSeen ?: module.lastSeen,
                    lastMessage = lastMessage ?: module.lastMessage,
                    thermOrientation = thermOrientation ?: module.thermOrientation,
                    thermRelayCmd = thermRelayCmd ?: module.thermRelayCmd,
                    setupDate = setupDate ?: module.setupDate,
                    roomId = roomId ?: module.roomId,
                    rfStrength = rfStrength ?: module.rfStrength)
}