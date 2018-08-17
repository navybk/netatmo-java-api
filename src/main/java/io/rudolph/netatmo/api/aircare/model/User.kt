package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * User related information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
        @JsonProperty("mail")
        val mail: String? = null,

        @JsonProperty("devices")
        val devices: List<String>? = null,

        @JsonProperty("administrative")
        val administrative: Administrative? = null,

        @JsonProperty("timeline_not_read")
        val timelineNotRead: Int? = null,

        @JsonProperty("timeline_size")
        val timelineSize: Int? = null,

        @JsonProperty("_id")
        val id: String? = null,

        @JsonProperty("friend_devices")
        val friendDevices: List<String>? = null,

        @JsonProperty("date_creation")
        val dateCreation: DateCreation? = null
)