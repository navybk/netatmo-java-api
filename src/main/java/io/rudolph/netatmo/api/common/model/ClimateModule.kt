package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.DashboardData
import java.time.LocalDateTime

abstract class ClimateModule : Module() {

    @JsonProperty("data_type")
    val dataType: List<String>? = null

    @JsonProperty("last_setup")
    val lastSetup: LocalDateTime? = null

    /**
     * Version of the software
     */
    @JsonProperty("firmware")
    private val firmware: Int? = null

    @JsonProperty("last_message")
    val lastMessage: LocalDateTime? = null

    @JsonProperty("last_seen")
    val lastSeen: LocalDateTime? = null

    @JsonProperty("battery_vp")
    private val batteryVP: Int? = null

    /**
     * Last data measured per device
     */
    @JsonProperty("dashboard_data")
    private val dashboardData: DashboardData? = null
}