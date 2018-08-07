package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class GlobalInfo(
        @JsonProperty("show_tags")
        val showTags: Boolean? = null
)