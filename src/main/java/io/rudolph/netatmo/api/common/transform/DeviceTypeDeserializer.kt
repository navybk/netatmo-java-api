package io.rudolph.netatmo.api.common.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.common.model.DeviceType


internal class DeviceTypeDeserializer : JsonDeserializer<DeviceType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): DeviceType {
        return p?.valueAsString?.let { name ->
            DeviceType.values().find {
                it.value == name
            }
        } ?: DeviceType.UNKNOWN
    }
}
