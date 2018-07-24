package io.rudolph.netatmo.api.common.model

enum class Scale(val value: String) {
    MAX("max"),

    HALFHOUR("30min"),

    HOUR("1hour"),

    THREEHOURS("3hours"),

    DAY("1day"),

    WEEK("1week"),

    MONTH("1month"),

    UNKNOWN("unknown")

}