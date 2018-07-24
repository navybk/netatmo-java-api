package io.rudolph.netatmo.api.weather.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.rudolph.netatmo.api.basemodel.DeviceType

data class Station(
        /**
         * id of the station
         */
        @JsonProperty("_id")
        val id: String,

        /**
         * Information about the station location (latitude/longitude of the station, altitude (meters), timezone)
         */
        @JsonProperty("place")
        val place: Place,

        @JsonProperty("mark")
        val mark: Int,

        /**
         * Latest measurements of the station, organized by module
         */
        @JsonProperty("measures")
        val measures: MeasureMap? = MeasureMap(),

        /**
         * list of available modules
         */
        @JsonProperty("modules")
        val modules: MutableList<String>? = mutableListOf(),

        /**
         *
         */
        @JsonProperty("module_types")
        val moduleTypes: MutableMap<String, DeviceType>?= mutableMapOf()
)