package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime


data class Person(
        @JsonProperty("face")
        val face: Face? = null,

        @JsonProperty("last_seen")
        val lastSeen: LocalDateTime? = null,

        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("pseudo")
        val pseudo: String? = null,

        @JsonProperty("out_of_sight")
        val outOfSight: Boolean? = null
)