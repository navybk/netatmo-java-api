package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Snapshot(
        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("version")
        val version: Int? = null,

        @JsonProperty("key")
        val key: String? = null,

        @JsonProperty("url")
        val url: String? = null,

        @JsonProperty("filename")
        val filename: String? = null
)