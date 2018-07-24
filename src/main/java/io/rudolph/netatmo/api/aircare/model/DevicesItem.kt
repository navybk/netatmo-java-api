package apiresults.aircare

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.aircare.model.DashboardData
import io.rudolph.netatmo.api.aircare.model.Place
import java.time.LocalDateTime


data class DevicesItem(
        @JsonProperty("cipher_id")
        private val cipherId: String? = null,

        @JsonProperty("type")
        private val type: String? = null,

        /**
         * Date when the Healthy Home Coach was set up
         */
        @JsonProperty("date_setup")
        private val dateSetup: LocalDateTime? = null,

        @JsonProperty("last_setup")
        private val lastSetup: Int? = null,

        @JsonProperty("last_upgrade")
        private val lastUpgrade: Int? = null,

        @JsonProperty("co2_calibrating")
        private val co2Calibrating: Boolean? = null,

        /**
         * Wifi status of the Healthy Home Coach. (86=bad, 56=good)
         */
        @JsonProperty("wifi_status")
        private val wifiStatus: Int? = null,

        /**
         * Array of data measured by Healthy Home Coach
         */
        @JsonProperty("data_type")
        private val dataType: List<String>? = null,

        /**
         * Name the user gave their Healthy Home Coach
         */
        @JsonProperty("name")
        private val name: String? = null,

        @JsonProperty("_id")
        private val id: String? = null,

        /**
         * Data about the location of the device.
         */
        @JsonProperty("place")
        private val place: Place? = null,

        /**
         * Last data measured per device
         */
        @JsonProperty("dashboard_data")
        private val dashboardData: DashboardData? = null,

        @JsonProperty("last_status_store")
        private val lastStatusStore: Int? = null,

        /**
         * Version of the software
         */
        @JsonProperty("firmware")
        private val firmware: Int? = null
)