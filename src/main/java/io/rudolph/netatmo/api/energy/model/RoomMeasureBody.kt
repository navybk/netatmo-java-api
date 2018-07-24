package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty


data class RoomMeasureBody(
        @JsonProperty("beg_time")
        var begTime: Int? = null,

        @JsonProperty("step_time")
        var stepTime: Int? = null,

        @JsonAnySetter
        var value: MutableMap<String, MutableList<Float>>? = mutableMapOf()

) {
    @JsonAnyGetter
    fun add(key: String?, list: MutableList<Float>?) {
        key ?: return
        list ?: return
        value?.put(key, list)
    }

}