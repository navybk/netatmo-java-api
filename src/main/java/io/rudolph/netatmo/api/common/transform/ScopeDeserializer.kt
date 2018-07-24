package io.rudolph.netatmo.api.common.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.oauth2.model.Scope


class ScopeDeserializer : JsonDeserializer<Scope>() {
    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): Scope {
        return p?.readValueAs(String::class.java).let { scopeName ->
            Scope.values().find {
                it.value == scopeName
            }
        } ?: Scope.UNKNOWN
    }
}
