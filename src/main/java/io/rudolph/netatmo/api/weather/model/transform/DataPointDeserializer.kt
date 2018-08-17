package io.rudolph.netatmo.api.weather.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.weather.model.DataPoint
import java.time.LocalDateTime
import java.time.ZoneOffset


class DataPointDeserializer : JsonDeserializer<DataPoint<*>>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): DataPoint<*>? {

        val array = p.readValueAs(Array<Any?>::class.java)
        val ts = (array[0] as? Int)?.toLong()?.let {
            LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC)
        } ?: return null

        if (array.size > 1) {
            return DataPoint(ts, array[1])
        }
        return DataPoint(ts, null)

    }
}
