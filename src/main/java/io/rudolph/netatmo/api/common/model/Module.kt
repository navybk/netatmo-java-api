package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.rudolph.netatmo.api.energy.model.module.RelayModule
import io.rudolph.netatmo.api.energy.model.module.ThermostatModule
import io.rudolph.netatmo.api.energy.model.module.ValveModule
import io.rudolph.netatmo.api.security.model.IndoorSireneModule


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes(
        Type(value = ValveModule::class, name = Constant.VALVE_API_STRING),
        Type(value = ThermostatModule::class, name = Constant.THERMOSTAT_API_STRING),
        Type(value = RelayModule::class, name = Constant.RELAY_API_STRING),
        Type(value = ClimateModule::class, name = Constant.INDOORMODULE_API_STRING),
        Type(value = ClimateModule::class, name = Constant.OUTDOORMODULE_API_STRING),
        Type(value = ClimateModule::class, name = Constant.RAINGAUGEMODULE_API_STRING),
        Type(value = ClimateModule::class, name = Constant.WINDMODULE_API_STRING),
        Type(value = IndoorSireneModule::class, name = Constant.INDOOR_SIRENE_API_STRING)
)
abstract class Module internal constructor(

        @JsonProperty("id")
        @field:JsonAlias("id", "_id")
        @param:JsonAlias("id", "_id")
        open val id: String = "notset",

        /**
         * 90 = low
         * 80 = medium
         * 70 = high
         * 60 = full signal
         */
        @JsonProperty("rf_status")
        @field:JsonAlias("rf", "rf_status", "rf_strength")
        @param:JsonAlias("rf", "rf_status", "rf_strength")
        open val rfStrength: Int? = null,

        /**
         * Battery level
         */
        @JsonProperty("battery_percent")
        @field:JsonAlias("battery_percent")
        @param:JsonAlias("battery_percent")
        open val batteryLevelInPercent: Int? = null,

        /**
         * Module Name
         */
        @field:JsonAlias("module_name", "name")
        @param:JsonAlias("module_name", "name")
        open val moduleName: String? = null,

        @field:JsonAlias("type")
        @param:JsonAlias("type")
        open val type: DeviceType = DeviceType.UNKNOWN
)