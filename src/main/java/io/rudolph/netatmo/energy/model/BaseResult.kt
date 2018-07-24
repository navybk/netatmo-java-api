package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


open class BaseResult(

        @JsonProperty("status")
        var status: String? = null,

        @JsonProperty("time_exec")
        var timeExec: Float? = null,

        @JsonProperty("time_server")
        var timeServer: Long? = null
)

