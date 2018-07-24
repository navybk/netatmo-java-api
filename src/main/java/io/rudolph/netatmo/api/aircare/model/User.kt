package io.rudolph.netatmo.api.aircare.model

import com.fasterxml.jackson.annotation.JsonProperty


data class User (
        @JsonProperty("mail")
    private val mail: String? = null,

        @JsonProperty("devices")
    private val devices: List<String>? = null,

        @JsonProperty("administrative")
    private val administrative: Administrative? = null,

        @JsonProperty("timeline_not_read")
    private val timelineNotRead: Int? = null,

        @JsonProperty("timeline_size")
    private val timelineSize: Int? = null,

        @JsonProperty("_id")
    private val id: String? = null,

        @JsonProperty("friend_devices")
    private val friendDevices: List<String>? = null,

        @JsonProperty("date_creation")
    private val dateCreation: DateCreation? = null
)