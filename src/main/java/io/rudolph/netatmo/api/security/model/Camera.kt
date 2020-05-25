package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType
import java.time.LocalDateTime


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
        val type: DeviceType? = DeviceType.UNKNOWN,

        @JsonProperty("is_local")
        val isLocal: Boolean? = null,

        @JsonProperty("vpn_url")
        val vpnUrl: String? = null,

        @JsonProperty("status")
        val status: String? = null,

        @JsonProperty("last_setup")
        val lastSetup: LocalDateTime? = null,

        //TODO: Evaluate for enum usage
        @JsonProperty("light_mode_status")
        val lastModeStatus: String? = null

)