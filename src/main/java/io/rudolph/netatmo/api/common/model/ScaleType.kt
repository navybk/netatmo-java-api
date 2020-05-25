package io.rudolph.netatmo.api.common.model

enum class ScaleType(val value: String, val unit: String? = null) {
    TEMPERATURE("temperature", "°C"),
    CO2("co2", "ppm"),
    HUMIDITY("humidity", "%"),
    PRESSURE("pressure", "mbar"),
    NOISE("noise", "db"),
    RAIN("rain", "mm"),
    WINDSTRENGTH("windStrength", "km/h"),
    WINDANGLE("windAngle", "angles"),
    GUSTSTRENGTH("guststrength", "km/h"),
    GUSTANGLE("gustAngle", "angles"),
    MIN_TEMP("min_temp"),
    MAX_TEMP("max_temp"),
    MIN_HUM("min_hum"),
    MAX_HUM("max_hum"),
    MAX_PRESSURE("max_pressure"),
    SUM_RAIN("sum_rain"),
    DATE_MAX_HUM("date_max_hum"),
    MIN_PRESSURE("min_pressure"),
    DATE_MIN_PRESSURE("date_min_pressure"),
    DATE_MAX_PRESSURE("date_max_pressure"),
    MIN_NOISE("min_noise"),
    DATE_MIN_NOISE("date_min_noise"),
    MAX_NOISE("max_noise"),
    DATE_MAX_NOISE("date_max_noise"),
    DATE_MIN_CO2("date_min_co2"),
    DATE_MAX_CO2("date_max_co2"),
    DATE_MAX_GUST("date_max_gust"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return this.value
    }
}