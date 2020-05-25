package io.rudolph.netatmo.api.common.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.common.model.BatteryState


internal class BatteryStateDeserializer : JsonDeserializer<BatteryState>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): BatteryState {
        return p?.valueAsString?.let { name ->
            BatteryState.values().find {
                it.value == name.toLowerCase()
            }
        } ?: BatteryState.NO_DATA
    }
}
