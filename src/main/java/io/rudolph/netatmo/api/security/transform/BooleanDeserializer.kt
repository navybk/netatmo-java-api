package io.rudolph.netatmo.api.security.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer


internal class BooleanDeserializer : JsonDeserializer<Boolean>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Boolean? {
        return when (p?.valueAsString?.toUpperCase()) {
            "1", "ON", "TRUE" -> true
            "0", "OFF", "FALSE" -> false
            else -> null
        }
    }
}
