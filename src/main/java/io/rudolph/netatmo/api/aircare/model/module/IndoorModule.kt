package io.rudolph.netatmo.api.aircare.model.module

import io.rudolph.netatmo.api.common.model.ClimateModule
import io.rudolph.netatmo.api.common.model.DeviceType

class IndoorModule: ClimateModule(){
    override val type = DeviceType.INDOORMODULE
}