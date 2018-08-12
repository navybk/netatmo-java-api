package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.rudolph.netatmo.api.energy.model.module.RelayModule
import io.rudolph.netatmo.api.energy.model.module.ThermostatModule
import io.rudolph.netatmo.api.energy.model.module.ValveModule


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
        Type(value = ClimateModule::class, name = Constant.WINDMODULE_API_STRING)
)
abstract class Module {

    @JsonAlias("id", "_id")
    open val id: String? = null

    /**
     * 90 = low
     * 80 = medium
     * 70 = high
     * 60 = full signal
     */
    @JsonProperty("rf_status")
    open val rfStrength: Int? = null

    /**
     * Battery level
     */
    @JsonProperty("battery_percent")
    open val batteryLevelInPercent: Int? = null

    /**
     * Battery level
     */
    @JsonAlias("module_name", "name")
    open val moduleName: String? = null

    @JsonAlias("type")
    open val type: DeviceType = DeviceType.UNKNOWN
}