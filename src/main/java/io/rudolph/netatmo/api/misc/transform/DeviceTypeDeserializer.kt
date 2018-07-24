package io.rudolph.netatmo.api.misc.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.misc.model.DeviceType


class DeviceTypeDeserializer : JsonDeserializer<DeviceType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): DeviceType {
        return p?.valueAsString?.let { name ->
            DeviceType.values().find {
                it.value == name
            }
        } ?: DeviceType.UNKNOWN
    }
}
