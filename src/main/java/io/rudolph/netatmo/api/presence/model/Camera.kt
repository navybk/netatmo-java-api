package io.rudolph.netatmo.api.presence.model

import com.fasterxml.jackson.annotation.JsonProperty


data class Camera(
        @JsonProperty("alim_status")
        val alimStatus: String? = null,

        @JsonProperty("sd_status")
        val sdStatus: String? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("type")
        val type: String? = null,

        @JsonProperty("is_local")
        val isLocal: Boolean? = null,

        @JsonProperty("vpn_url")
        val vpnUrl: String? = null,

        @JsonProperty("status")
        val status: String? = null
)