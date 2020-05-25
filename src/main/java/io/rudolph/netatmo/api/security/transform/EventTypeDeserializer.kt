package io.rudolph.netatmo.api.security.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.security.model.EventType


class EventTypeDeserializer : JsonDeserializer<EventType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): EventType {
        return p?.valueAsString?.let { name ->
            EventType.values().find {
                it.value == name
            }
        } ?: EventType.UNKNOWN
    }
}
