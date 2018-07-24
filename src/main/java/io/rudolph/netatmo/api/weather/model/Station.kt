package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Station(
        @JsonProperty("_id")
        val id: String,

        @JsonProperty("place")
        val place: Place,

        @JsonProperty("mark")
        val mark: Int,

        @JsonProperty("measures")
        val measures: MeasureMap? = MeasureMap(),

        @JsonProperty("modules")
        val modules: MutableList<String>? = mutableListOf(),

        @JsonProperty("module_types")
        val moduleTypes: MutableMap<String, String>?= mutableMapOf()
)