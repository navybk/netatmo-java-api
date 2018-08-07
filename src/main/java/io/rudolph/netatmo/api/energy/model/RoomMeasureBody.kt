package io.rudolph.netatmo.api.energy.model

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty


data class RoomMeasureBody(
        @JsonProperty("beg_time")
        val begTime: Int? = null,

        @JsonProperty("step_time")
        val stepTime: Int? = null,

        @JsonAnySetter
        val value: MutableMap<String, MutableList<Float>>? = mutableMapOf()

) {
    @JsonAnyGetter
    fun add(key: String?, list: MutableList<Float>?) {
        key ?: return
        list ?: return
        value?.put(key, list)
    }

}