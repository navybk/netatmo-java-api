package io.rudolph.netatmo

import com.fasterxml.jackson.databind.DeserializationConfig
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.rudolph.netatmo.api.aircare.model.LatLong
import io.rudolph.netatmo.api.aircare.transform.LatLongDeserializer
import io.rudolph.netatmo.api.common.model.BatteryState
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.common.model.Scale
import io.rudolph.netatmo.api.common.model.ScaleType
import io.rudolph.netatmo.api.common.transform.*
import io.rudolph.netatmo.api.energy.model.RoomType
import io.rudolph.netatmo.api.energy.model.TemperatureType
import io.rudolph.netatmo.api.energy.model.ThermMode
import io.rudolph.netatmo.api.energy.model.ZoneType
import io.rudolph.netatmo.api.energy.model.transform.*
import io.rudolph.netatmo.api.security.model.EventType
import io.rudolph.netatmo.api.security.transform.EventTypeDeserializer
import io.rudolph.netatmo.api.weather.model.DataPoint
import io.rudolph.netatmo.api.weather.model.Measure
import io.rudolph.netatmo.api.weather.transform.DataPointDeserializer
import io.rudolph.netatmo.api.weather.transform.MeasureDeserializer
import io.rudolph.netatmo.oauth2.model.Scope
import retrofit2.converter.jackson.JacksonConverterFactory
import java.time.LocalDateTime


internal object JacksonTransform {
    val mapper = ObjectMapper().apply {
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)

        registerModule(SimpleModule().apply {
            addDeserializer(Scope::class.java, ScopeDeserializer())
            addDeserializer(ThermMode::class.java, ThermModeDeserializer())
            addDeserializer(DeviceType::class.java, DeviceTypeDeserializer())
            addDeserializer(TemperatureType::class.java, TemperaturTypeDeserializer())
            addDeserializer(RoomType::class.java, RoomTypeDeserializer())
            addDeserializer(ZoneType::class.java, ZoneTypeDeserializer())
            addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer())
            addDeserializer(Measure::class.java, MeasureDeserializer())
            addDeserializer(ScaleType::class.java, ScaleTypeDeserializer())
            addDeserializer(EventType::class.java, EventTypeDeserializer())
            addDeserializer(BatteryState::class.java, BatteryStateDeserializer())
            addDeserializer(DataPoint::class.java, DataPointDeserializer())
            addDeserializer(LatLong::class.java, LatLongDeserializer())

            addDeserializer(Scale::class.java, ScaleDeserializer())
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

    var debug: Boolean = false
        set (value) {
            field = value
            if (value) {
                mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            } else {
                mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            }
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