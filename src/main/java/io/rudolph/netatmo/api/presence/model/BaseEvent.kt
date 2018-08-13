package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class BaseEvent(
        /**
         * Identifier of the event
         */
        @JsonProperty("id")
        @JsonAlias("id", "event_id")
        override val id: String? = null)
    : Event()