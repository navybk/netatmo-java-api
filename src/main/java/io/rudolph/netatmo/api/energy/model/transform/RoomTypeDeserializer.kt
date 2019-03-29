package io.rudolph.netatmo.api.energy.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.energy.model.RoomType


class RoomTypeDeserializer : JsonDeserializer<RoomType>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): RoomType {
        return p?.readValueAs(String::class.java).let { name ->
            RoomType.values().find {
                it.value == name
            } ?: RoomType.CUSTOM
        }
    }
}
