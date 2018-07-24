package io.rudolph.netatmo.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.energy.model.constants.Constants
import java.time.LocalDateTime
import java.time.ZoneOffset


class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): LocalDateTime {
        if (p.isNaN) {
            p.valueAsString.apply {
                return this.toLongOrNull()?.let {
                    LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC)
                } ?: try {
                    LocalDateTime.parse(this)
                } catch (e: Exception) {
                    Constants.INVALID_LOCALDATETIME
                }
            }
        }
        p.readValueAs(Long::class.java)?.apply {
            if (this != 0L) {
                return LocalDateTime.ofEpochSecond(this, 0, ZoneOffset.UTC)
            }
        }
        return Constants.INVALID_LOCALDATETIME


    }
}
