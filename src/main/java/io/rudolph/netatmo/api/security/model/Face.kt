package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Face(
        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("version")
        val version: Int? = null,

        @JsonProperty("key")
        val key: String? = null,

        @JsonProperty("url")
        val url: String? = null
)