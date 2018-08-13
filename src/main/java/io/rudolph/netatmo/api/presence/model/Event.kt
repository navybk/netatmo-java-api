package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty


abstract class Event {
    /**
     * Subtypes of SD and Alim events. Go to Cameras page for further details.
     *
     * TODO change type to [EventSubType]
     */
    @JsonProperty("sub_type")
    val subType: EventType? = null

    /**
     * Camera that detected the event
     */
    @JsonProperty("camera_id")
    val cameraId: String? = null

    /**
     * Status of the video (recording deleted or available)
     */
    @JsonProperty("video_status")
    val videoStatus: String? = null

    /**
     * Identifier of the event
     */
    @JsonProperty("id")
    @JsonAlias("id", "event_id")
    open val id: String? = null

    /**
     * Time of occurence of event
     */
    @JsonProperty("time")
    val time: Int? = null

    /**
     * Type of events.
     */
    @JsonProperty("type")
    @JsonAlias("event_type", "type")
    val type: EventType? = null

    /**
     * User facing event description
     */
    @JsonProperty("message")
    val message: String? = null

    /**
     * If person was considered "away" before being seen during this event
     */
    @JsonProperty("is_arrival")
    val isArrival: Boolean? = null

    /**
     * Snapshot id version and key. (Used in [io.rudolph.netatmo.api.presence.PresenceConnector.getCameraPicture])
     */
    @JsonProperty("snapshot")
    val snapshot: Snapshot? = null

    /**
     * Id of the person the event is about (if any)
     */
    @JsonProperty("person_id")
    val personId: String? = null

    /**
     * Identifier of the video
     */
    @JsonProperty("video_id")
    val videoId: String? = null
}