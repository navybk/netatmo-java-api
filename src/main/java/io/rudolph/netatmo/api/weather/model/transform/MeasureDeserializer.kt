package io.rudolph.netatmo.api.weather.model.transform

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.rudolph.netatmo.api.weather.model.Measure
import com.fasterxml.jackson.databind.JsonNode
import io.rudolph.netatmo.api.weather.model.BaseOutdoorMeasure
import io.rudolph.netatmo.api.weather.model.RainGaugeMeasure
import io.rudolph.netatmo.api.weather.model.WindMeasure
import io.rudolph.netatmo.transform.JacksonTransform


class MeasureDeserializer : JsonDeserializer<Measure>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): Measure? {
        val node: JsonNode = p.readValueAsTree()
        node.findValue ("res" )?.apply {
            return JacksonTransform.mapper.treeToValue(node, BaseOutdoorMeasure::class.java)
        }

        node.findValue ("rain_timeutc" )?.apply {
            return JacksonTransform.mapper.treeToValue(node, RainGaugeMeasure::class.java)
        }

        node.findValue ("wind_timeutc" )?.apply {
            return JacksonTransform.mapper.treeToValue(node, WindMeasure::class.java)
        }

        return null
    }
}
