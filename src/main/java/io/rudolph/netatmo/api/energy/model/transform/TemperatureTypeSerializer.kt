package io.rudolph.netatmo.api.energy.model.transform

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.rudolph.netatmo.api.energy.model.TemperatureType


class TemperatureTypeSerializer : JsonSerializer<TemperatureType>() {
    override fun serialize(value: TemperatureType, gen: JsonGenerator, serializers: SerializerProvider?) {
        gen.writeString(value.value)
    }

}
