package io.rudolph.netatmo.api.weather.model

import io.rudolph.netatmo.api.common.model.ClimateModule
import io.rudolph.netatmo.api.common.model.DeviceType

class RainGaugeModule: ClimateModule(){
    override val type = DeviceType.WINDMODULE
}