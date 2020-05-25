package io.rudolph.netatmo.api.common.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.common.model.Scale


internal class ScaleDeserializer : JsonDeserializer<Scale>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Scale {
        return p?.valueAsString?.let { name ->
            Scale.values().find {
                it.value == name
            }
        } ?: Scale.UNKNOWN
    }
}
