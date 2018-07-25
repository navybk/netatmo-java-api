package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Event(
        /**
         * Subtypes of SD and Alim events. Go to Cameras page for further details.
         *
         * TODO change type to [EventSubType]
         */
        @JsonProperty("sub_type")
        private val subType: String? = null,

        /**
         * Camera that detected the event
         */
        @JsonProperty("camera_id")
        private val cameraId: String? = null,

        /**
         * Status of the video (recording, deleted or available)
         */
        @JsonProperty("video_status")
        private val videoStatus: String? = null,

        /**
         * Identifier of the event
         */
        @JsonProperty("id")
        private val id: String? = null,

        /**
         * Time of occurence of event
         */
        @JsonProperty("time")
        private val time: Int? = null,

        /**
         * Type of events.
         */
        @JsonProperty("type")
        private val type: EventType? = null,

        /**
         * User facing event description
         */
        @JsonProperty("message")
        private val message: String? = null,

        /**
         * If person was considered "away" before being seen during this event
         */
        @JsonProperty("is_arrival")
        private val isArrival: Boolean? = null,

        /**
         * Snapshot id, version and key. (Used in [io.rudolph.netatmo.api.presence.PresenceConnector.getCameraPicture])
         */
        @JsonProperty("snapshot")
        private val snapshot: Snapshot? = null,

        /**
         * Id of the person the event is about (if any)
         */
        @JsonProperty("person_id")
        private val personId: String? = null,

        /**
         * Identifier of the video
         */
        @JsonProperty("video_id")
        private val videoId: String? = null
)