package io.rudolph.netatmo.api.energy.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.energy.model.TemperatureType


class TemperaturTypeDeserializer : JsonDeserializer<TemperatureType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): TemperatureType {
        return p?.readValueAs(String::class.java).let { name ->
            TemperatureType.values().find {
                it.value == name
            }
        } ?: TemperatureType.UNKNOWN
    }
}
