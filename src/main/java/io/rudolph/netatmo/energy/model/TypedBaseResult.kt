package io.rudolph.netatmo.energy.model

import com.fasterxml.jackson.annotation.JsonProperty


data class TypedBaseResult<T>(
        @JsonProperty("body")
        var body: T? = null,

        @JsonProperty("status")
        var inStatus: String? = null,

        @JsonProperty("time_exec")
        var inTimeExec: Float? = null,

        @JsonProperty("time_server")
        var inTimeServer: Long? = null
): BaseResult(
        inStatus,
        inTimeExec,
        inTimeServer
)

