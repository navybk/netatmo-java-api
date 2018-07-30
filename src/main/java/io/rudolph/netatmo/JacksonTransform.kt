package io.rudolph.netatmo

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.common.model.Scale
import io.rudolph.netatmo.api.common.model.ScaleType
import io.rudolph.netatmo.api.common.transform.*
import io.rudolph.netatmo.api.energy.model.TemperatureType
import io.rudolph.netatmo.api.energy.model.ThermMode
import io.rudolph.netatmo.api.energy.model.ZoneType
import io.rudolph.netatmo.api.energy.model.transform.*
import io.rudolph.netatmo.api.presence.model.EventType
import io.rudolph.netatmo.api.presence.transform.EventTypeDeserializer
import io.rudolph.netatmo.api.weather.model.Measure
import io.rudolph.netatmo.api.weather.model.transform.MeasureDeserializer
import io.rudolph.netatmo.oauth2.model.Scope
import retrofit2.converter.jackson.JacksonConverterFactory
import java.time.LocalDateTime


internal object JacksonTransform {
    val mapper = ObjectMapper().apply {
        enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)

        registerModule(SimpleModule().apply {
            addDeserializer(Scope::class.java, ScopeDeserializer())
            addDeserializer(ThermMode::class.java, ThermModeDeserializer())
            addDeserializer(DeviceType::class.java, DeviceTypeDeserializer())
            addDeserializer(TemperatureType::class.java, TemperaturTypeDeserializer())
            addDeserializer(ZoneType::class.java, ZoneTypeDeserializer())
            addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer())
            addDeserializer(Measure::class.java, MeasureDeserializer())
            addDeserializer(Scale::class.java, ScaleDeserializer())
            addDeserializer(ScaleType::class.java, ScaleTypeDeserializer())
            addDeserializer(EventType::class.java, EventTypeDeserializer())

            addSerializer(ThermMode::class.java, ThermModeSerializer())
            addSerializer(DeviceType::class.java, DeviceTypeSerializer())
            addSerializer(ZoneType::class.java, ZoneTypeSerializer())
            addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer())
            addSerializer(Scale::class.java, ScaleSerializer())
            addSerializer(ScaleType::class.java, ScaleTypeSerializer())

            addKeyDeserializer(LocalDateTime::class.java, LocalDateTimeKeyDeserializer())

        })
        registerKotlinModule()
    }

    val jacksonConverterFactory = JacksonConverterFactory.create(mapper)
            ?: throw IllegalStateException("Was not able to instantiate converter")

    inline fun <reified T> deserialize(jsonString: String): T? {
        return try {
            mapper.readValue(jsonString, T::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    inline fun <reified T> parse(value: String): T? {
        return try {
            mapper.readValue(value, T::class.java)
        } catch (e: Exception) {
            null
        }
    }
}