package io.rudolph.netatmo.api.common.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.common.model.ScaleType


internal class ScaleTypeDeserializer : JsonDeserializer<ScaleType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): ScaleType {
        return p?.valueAsString?.let { name ->
            ScaleType.values().find {
                it.value == name
            }
        } ?: ScaleType.UNKNOWN
    }
}
