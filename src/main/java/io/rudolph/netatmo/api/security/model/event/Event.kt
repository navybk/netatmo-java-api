package io.rudolph.netatmo.api.security.model.event

import com.fasterxml.jackson.annotation.*
import io.rudolph.netatmo.api.security.model.EventType
import java.time.LocalDateTime

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl = Event::class,
        visible = true
)
@JsonSubTypes(
        JsonSubTypes.Type(value = PersonCameraEvent::class, name = "person"),
        JsonSubTypes.Type(value = ConnectionEvent::class, name = "connection"),
        JsonSubTypes.Type(value = MovementCameraEvent::class, name = "movement"),
        JsonSubTypes.Type(value = OutdoorCameraEvent::class, name = "outdoor")
)
@JsonIgnoreProperties(ignoreUnknown = true)
open class Event {
    /**
     * Identifier of the event
     */
    @JsonProperty("id")
    @JsonAlias("id", "event_id")
    val id: String? = null

    /**
     * Type of events.
     */
    @JsonProperty("type")
    @JsonAlias("event_type", "type")
    val type: EventType? = null

    /**
     * Time of occurence of event
     */
    @JsonProperty("time")
    val time: LocalDateTime? = null

    /**
     * User facing event description
     */
    @JsonProperty("message")
    val message: String? = null
}