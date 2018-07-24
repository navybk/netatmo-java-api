package io.rudolph.netatmo.api.energy.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.energy.model.DeviceType


class DeviceTypeDeserializer : JsonDeserializer<DeviceType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): DeviceType {
        return p?.readValueAs(String::class.java).let { name ->
            DeviceType.values().find {
                it.value == name
            }
        } ?: DeviceType.UNKNOWN
    }
}
