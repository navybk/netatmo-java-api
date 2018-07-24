package io.rudolph.netatmo.api.energy.model.transform

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.rudolph.netatmo.api.energy.model.ThermMode


class ThermModeSerializer : JsonSerializer<ThermMode>() {
    override fun serialize(value: ThermMode, gen: JsonGenerator, serializers: SerializerProvider?) {
        gen.writeString(value.value)
    }
}
