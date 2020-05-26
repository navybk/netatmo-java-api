package io.rudolph.netatmo.api.common.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import io.rudolph.netatmo.api.aircare.model.DashboardData
import io.rudolph.netatmo.api.aircare.model.HomeCoachDevice
import io.rudolph.netatmo.api.aircare.model.Place
import io.rudolph.netatmo.api.weather.model.BaseStationDevice
import java.time.LocalDateTime

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = BaseDevice::class,
        visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(value = HomeCoachDevice::class, name = Constant.HOMECOACH_API_STRING),
        JsonSubTypes.Type(value = BaseStationDevice::class, name = Constant.BASESTATION_API_STRING)
)
abstract class Device {
    @JsonProperty("cipher_id")
    val cipherId: String? = null

    abstract val type: DeviceType

    /**
     * Date when the Healthy Home Coach was set up
     */
    @JsonProperty("date_setup")
    val dateSetup: LocalDateTime? = null

    @JsonProperty("last_setup")
    val lastSetup: LocalDateTime? = null

    @JsonProperty("last_upgrade")
    val lastUpgrade: Int? = null

    @JsonProperty("co2_calibrating")
    val co2Calibrating: Boolean? = null

    /**
     * Wifi status of the Healthy Home Coach. (86=bad 56=good)
     */
    @JsonProperty("wifi_status")
    val wifiStatus: Int? = null

    /**
     * Array of data measured by Healthy Home Coach
     */
    @JsonProperty("data_type")
    val dataType: List<String>? = null

    /**
     * Name the user gave their Healthy Home Coach
     */
    @JsonProperty("name")
    val name: String? = null

    @JsonProperty("_id")
    open val id: String? = null

    /**
     * Data about the location of the device.
     */
    @JsonProperty("place")
    val place: Place? = null

    /**
     * Last data measured per device
     */
    @JsonProperty("dashboard_data")
    val dashboardData: DashboardData? = null

    @JsonProperty("last_status_store")
    val lastStatusStore: LocalDateTime? = null

    /**
     * Version of the software
     */
    @JsonProperty("firmware")
    val firmware: Int? = null

    /**
     * Name of module
     */
    @JsonProperty("module_name")
    val moduleName: String? = null

    /**
     * Name of Station
     */
    @JsonProperty("station_name")
    val stationName: String? = null

    @JsonProperty("reachable")
    val reachable: Boolean?= null

    @JsonProperty("read_only")
    val read_only: Boolean?= null

    val wifiLevel: WifiLevel
        get() = WifiLevel.wifiLevelForSignalStrength(wifiStatus)
}
