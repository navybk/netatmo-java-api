package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty


data class Face(
        @JsonProperty("id")
        @field:JsonAlias("face_id")
        @param:JsonAlias("face_id")
        val id: String? = null,

        @JsonProperty("version")
        val version: Int? = null,

        @JsonProperty("key")
        val key: String? = null,

        @JsonProperty("url")
        val url: String? = null
)