package io.rudolph.netatmo.energy.model.transform

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.rudolph.netatmo.energy.model.ZoneType


class ZoneTypeSerializer : JsonSerializer<ZoneType>() {
    override fun serialize(value: ZoneType, gen: JsonGenerator, serializers: SerializerProvider?) {
        gen.writeNumber(value.value)
    }
}
