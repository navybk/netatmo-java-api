package io.rudolph.netatmo.energy.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.energy.model.ZoneType


class ZoneTypeDeserializer : JsonDeserializer<ZoneType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): ZoneType {
        return p?.readValueAs(String::class.java).let { name ->
            ZoneType.values().find {
                it.value == name?.toInt()
            }
        } ?: ZoneType.INVALID
    }
}
