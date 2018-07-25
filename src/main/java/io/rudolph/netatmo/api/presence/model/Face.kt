package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Face(
        @JsonProperty("id")
        private val id: String? = null,

        @JsonProperty("version")
        private val version: Int? = null,

        @JsonProperty("key")
        private val key: String? = null
)