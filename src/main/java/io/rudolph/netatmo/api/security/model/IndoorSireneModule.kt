package io.rudolph.netatmo.api.security.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.rudolph.netatmo.api.common.model.Module
import io.rudolph.netatmo.api.security.transform.BooleanDeserializer


data class IndoorSireneModule(
        @JsonProperty("monitoring")
        @JsonDeserialize(using = BooleanDeserializer::class)
        val monitoring: Boolean? = null,

        @JsonProperty("status")
        val status: String? = null,

        @JsonProperty("alim_source")
        val alimSource: String = "battery",

        @JsonProperty("tamper_detection_enabled")
        @JsonDeserialize(using = BooleanDeserializer::class)
        val tamperDetectionEnabled: Boolean? = null
) : Module()