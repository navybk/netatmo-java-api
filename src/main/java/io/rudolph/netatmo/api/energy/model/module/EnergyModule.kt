package io.rudolph.netatmo.api.energy.model.module

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.Module
import java.time.LocalDateTime

abstract class EnergyModule : Module() {

    @JsonProperty("setup_date")
    val setupDate: LocalDateTime? = null

    @JsonAlias("rf_strength", "rf_status")
    override val rfStrength: Int? = null

    /**
     * 56 good
     * 86 poor
     */
    @JsonProperty("wifi_strength")
    val wifiStrength: Int? = null
}