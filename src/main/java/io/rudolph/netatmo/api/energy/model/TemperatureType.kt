package io.rudolph.netatmo.api.energy.model


enum class TemperatureType(val value: String) {
    TEMPERATURE("temperature"),
    SP_TEMPERATURE("sp_temperature"),
    MIN_TEMP("min_temp"),
    MAX_TEMP("max_temp"),
    DATE_MIN_TEMP("date_min_temp"),
    DATE_MAX_TEMP("date_max_temp"),
    UNKNOWN("unknown");
}