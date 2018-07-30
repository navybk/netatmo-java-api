package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module
import java.time.LocalDateTime

abstract class EnergyModule: Module() {
    @JsonProperty("id")
    override val id: String? = null

    @JsonProperty("name")
    override var moduleName: String? = null

    @JsonProperty("setup_date")
    var setupDate: LocalDateTime? = null

    @JsonProperty("rf_strength")
    override var rfStrength: Int? = null

    /**
     * 56 good
     * 86 poor
     */
    @JsonProperty("wifi_strength")
    var wifiStrength: Int? = null
}