package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.JsonProperty

data class OutdoorCameraEvent(
        @JsonProperty("person_id")
        val personId: String? = null,

        @JsonProperty("video_id")
        val videoId: String? = null,

        @JsonProperty("video_status")
        val videoStatus: String? = null,

        @JsonProperty("event_list")
        val eventList: List<Event> = listOf()
) : CameraEvent()