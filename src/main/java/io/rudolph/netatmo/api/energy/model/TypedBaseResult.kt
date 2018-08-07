package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class TypedBaseResult<T>(
        @JsonProperty("body")
        val body: T? = null,

        @JsonProperty("status")
        val inStatus: String? = null,

        @JsonProperty("time_exec")
        val inTimeExec: Float? = null,

        @JsonProperty("time_server")
        val inTimeServer: Long? = null
) : BaseResult(
        inStatus,
        inTimeExec,
        inTimeServer
)

