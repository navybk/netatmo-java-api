package io.rudolph.netatmo.transform

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.rudolph.netatmo.oauth2.toTimestamp
import java.time.LocalDateTime


class LocalDateTimeSerializer : JsonSerializer<LocalDateTime>() {
    override fun serialize(value: LocalDateTime, gen: JsonGenerator, serializers: SerializerProvider?) {
        gen.writeNumber(value.toTimestamp())
    }

}
