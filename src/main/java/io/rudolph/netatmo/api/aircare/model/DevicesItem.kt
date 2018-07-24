package apiresults.aircare

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.DashboardData
import io.rudolph.netatmo.api.aircare.model.Place


data class DevicesItem(
        @JsonProperty("cipher_id")
        private val cipherId: String? = null,


        @JsonProperty("type")
        private val type: String? = null,


        @JsonProperty("date_setup")
        private val dateSetup: Int? = null,


        @JsonProperty("last_setup")
        private val lastSetup: Int? = null,


        @JsonProperty("last_upgrade")
        private val lastUpgrade: Int? = null,


        @JsonProperty("co2_calibrating")
        private val co2Calibrating: Boolean? = null,


        @JsonProperty("wifi_status")
        private val wifiStatus: Int? = null,


        @JsonProperty("data_type")
        private val dataType: List<String>? = null,


        @JsonProperty("name")
        private val name: String? = null,


        @JsonProperty("_id")
        private val id: String? = null,


        @JsonProperty("place")
        private val place: Place? = null,


        @JsonProperty("dashboard_data")
        private val dashboardData: DashboardData? = null,


        @JsonProperty("last_status_store")
        private val lastStatusStore: Int? = null,


        @JsonProperty("firmware")
        private val firmware: Int? = null
)