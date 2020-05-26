package io.rudolph.netatmo.api.weather.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.common.model.Module


class ModuleDeserializer : JsonDeserializer<List<Module>>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): List<Module>? {
        return p.readValueAsTree<JsonNode>().flatMap {
            it.map { module ->
                JacksonTransform.mapper
                        .convertValue(module, object : TypeReference<List<Module>>() {})
            }
        }.flatten()
    }
}
