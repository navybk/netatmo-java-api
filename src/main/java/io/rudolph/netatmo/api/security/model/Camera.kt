package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.common.model.Module
import java.time.LocalDateTime


data class Camera(

        @JsonProperty("id")
        val id: String? = null,

        @JsonProperty("type")
        val type: DeviceType? = DeviceType.UNKNOWN,

        @JsonProperty("status")
        val status: String? = null,

        @JsonProperty("vpn_url")
        val vpnUrl: String? = null,

        @JsonProperty("is_local")
        val isLocal: Boolean? = null,

        @JsonProperty("sd_status")
        val sdStatus: String? = null,

        @JsonProperty("alim_status")
        val alimStatus: String? = null,

        @JsonProperty("name")
        val name: String? = null,

        @JsonProperty("last_setup")
        val lastSetup: LocalDateTime? = null,

        //TODO: Evaluate for enum usage
        @JsonProperty("light_mode_status")
        val lightModeStatus: String? = null,

        @JsonProperty("modules")
        val modules: List<Module>,

        @JsonProperty("use_pin_code")
        val usePinCode: Boolean

)