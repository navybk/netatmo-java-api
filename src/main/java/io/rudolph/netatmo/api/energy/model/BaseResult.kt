package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


open class BaseResult(

        @JsonProperty("status")
        val status: String? = null,

        @JsonProperty("time_exec")
        val timeExec: Float? = null,

        @JsonProperty("time_server")
        val timeServer: Long? = null
)

