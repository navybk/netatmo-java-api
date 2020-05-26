package io.rudolph.netatmo.api.aircare.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.aircare.model.LatLong


internal class LatLongDeserializer : JsonDeserializer<LatLong>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): LatLong? {
        return p?.valueAsString?.split(",")
                ?.mapNotNull {
                    it.toDoubleOrNull()
                }
                ?.takeIf { it.size == 2 }
                ?.let {
                    LatLong(it[0], it[1])
                }
    }
}
