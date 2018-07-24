package io.rudolph.netatmo.transform

import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.KeyDeserializer
import io.rudolph.netatmo.api.energy.model.constants.Constants
import java.time.LocalDateTime
import java.time.ZoneOffset

class LocalDateTimeKeyDeserializer : KeyDeserializer() {
    override fun deserializeKey(key: String, ctxt: DeserializationContext?): Any {
        return key.toLongOrNull()?.let {
            LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC)
        } ?: try {
            LocalDateTime.parse(key)
        } catch (e: Exception) {
            Constants.INVALID_LOCALDATETIME
        }
    }
}