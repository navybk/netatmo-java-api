package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class BaseEvent(
        /**
         * Identifier of the event
         */
        @JsonProperty("id")
        @field:JsonAlias("id", "event_id")
        override val id: String? = null,

        /**
         * TODO: evaluate purpose
         */
        @JsonProperty("event_list")
        val eventList: List<BaseEvent>? = null) : Event()