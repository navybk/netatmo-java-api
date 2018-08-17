package io.rudolph.netatmo.api.weather.model

import java.time.LocalDateTime

data class DataPoint<T>(
        val timestamp: LocalDateTime,

        val value: T? = null
)