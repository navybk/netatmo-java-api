package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.rudolph.netatmo.api.aircare.model.module.IndoorModule
import io.rudolph.netatmo.api.energy.model.module.RelayModule
import io.rudolph.netatmo.api.energy.model.module.ThermosthatModule
import io.rudolph.netatmo.api.energy.model.module.ValveModule
import io.rudolph.netatmo.api.weather.model.OutdoorModule
import io.rudolph.netatmo.api.weather.model.RainGaugeModule
import io.rudolph.netatmo.api.weather.model.WindModule


@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes(
        Type(value = ValveModule::class, name = Constant.VALVE_API_STRING),
        Type(value = ThermosthatModule::class, name = Constant.THERMOSTAT_API_STRING),
        Type(value = RelayModule::class, name = Constant.RELAY_API_STRING),
        Type(value = IndoorModule::class, name = Constant.INDOORMODULE_API_STRING),
        Type(value = OutdoorModule::class, name = Constant.OUTDOORMODULE_API_STRING),
        Type(value = RainGaugeModule::class, name = Constant.RAINGAUGEMODULE_API_STRING),
        Type(value = WindModule::class, name = Constant.WINDMODULE_API_STRING)
)
abstract class Module {
    @JsonProperty("_id")
    open val id: String? = null

    /**
     * 90 = low
     * 80 = medium
     * 70 = high
     * 60 = full signal
     */
    @JsonProperty("rf_status")
    open var rfStrength: Int? = null

    /**
     * Battery level
     */
    @JsonProperty("battery_percent")
    open var batteryLevelInPercent: Int? = null

    /**
     * Battery level
     */
    @JsonProperty("module_name")
    open var moduleName: String? = null


    abstract val type: DeviceType
}