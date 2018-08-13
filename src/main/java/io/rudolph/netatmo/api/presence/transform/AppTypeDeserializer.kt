package io.rudolph.netatmo.api.presence.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.presence.model.AppType


class AppTypeDeserializer : JsonDeserializer<AppType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): AppType {
        return p?.valueAsString?.let { name ->
            AppType.values().find {
                it.value == name
            }
        } ?: AppType.UNKNOWN
    }
}
