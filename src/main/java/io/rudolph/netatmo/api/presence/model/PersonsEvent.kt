package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonsEvent(

        @JsonProperty("app_type")
        val appType: AppType,

        @JsonProperty("persons")
        val persons: List<PersonsEventPerson> = mutableListOf(),

        @JsonProperty("snapshot_id")
        val snapshotId: String?,

        @JsonProperty("snapshot_key")
        val snapshotKey: String?,

        @JsonProperty("home_id")
        val homeId: String,

        @JsonProperty("home_name")
        val homeName: String
) : Event()