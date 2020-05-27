package io.rudolph.netatmo.api.security.model.pushevent

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "event_type",
        defaultImpl = UnknownPushEvent::class,
        visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(value = SmokeAlarmPushEvent::class, name = "hush"),
        JsonSubTypes.Type(value = IndoorCameraOnOffPushEvent::class, name = "on"),
        JsonSubTypes.Type(value = IndoorCameraOnOffPushEvent::class, name = "off"),
        JsonSubTypes.Type(value = IndoorCameraMovementPushEvent::class, name = "movement"),
        JsonSubTypes.Type(value = IndoorCameraConnectedPushEvent::class, name = "connection"),
        JsonSubTypes.Type(value = IndoorCameraPersonPushEvent::class, name = "person"),
        JsonSubTypes.Type(value = OutdoorCameraHumanPushEvent::class, name = "human")
        )
abstract class PushEvent(

        @JsonProperty("user_id")
        @field:JsonAlias("user_id")
        @param:JsonAlias("user_id")
        val userId: String = "",

        @JsonProperty("event_type")
        @field:JsonAlias("event_type")
        @param:JsonAlias("event_type")
        val eventType: String = "",

        @JsonProperty("device_id")
        @field:JsonAlias("device_id")
        @param:JsonAlias("device_id")
        val deviceId: String = "",

        @JsonProperty("home_id")
        @field:JsonAlias("home_id")
        @param:JsonAlias("home_id")
        val homeId: String = "",

        @JsonProperty("home_name")
        @field:JsonAlias("home_name")
        @param:JsonAlias("home_name")
        val homeName: String = "",

        @JsonProperty("camera_id")
        @field:JsonAlias("camera_id")
        @param:JsonAlias("camera_id")
        val cameraId: String = "",

        @JsonProperty("event_id")
        @field:JsonAlias("event_id")
        @param:JsonAlias("event_id")
        val eventId: String = "",

        @JsonProperty("push_type")
        @field:JsonAlias("push_type")
        @param:JsonAlias("push_type")
        val pushType: String = "",

        @JsonProperty("message")
        @field:JsonAlias("message")
        @param:JsonAlias("message")
        val message: String = ""
)