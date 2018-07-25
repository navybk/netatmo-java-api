package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Person(
        @JsonProperty("face")
        private val face: Face? = null,

        @JsonProperty("last_seen")
        private val lastSeen: Int? = null,

        @JsonProperty("id")
        private val id: String? = null,

        @JsonProperty("pseudo")
        private val pseudo: String? = null,

        @JsonProperty("out_of_sight")
        private val outOfSight: Boolean? = null
)