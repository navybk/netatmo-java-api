package io.rudolph.netatmo.api.energy.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.energy.model.ThermMode


class ThermModeDeserializer : JsonDeserializer<ThermMode>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): ThermMode {
        return p?.readValueAs(String::class.java).let { name ->
            ThermMode.values().find {
                it.value == name
            }
        } ?: ThermMode.UNKNOWN
    }
}
