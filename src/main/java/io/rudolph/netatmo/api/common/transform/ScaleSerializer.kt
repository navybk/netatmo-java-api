package io.rudolph.netatmo.api.common.transform

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.rudolph.netatmo.api.common.model.Scale


class ScaleSerializer : JsonSerializer<Scale>() {
    override fun serialize(value: Scale, gen: JsonGenerator, serializers: SerializerProvider?) {
        gen.writeString(value.value)
    }

}
