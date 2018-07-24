package io.rudolph.netatmo.api.energy.model


enum class ThermMode(val value: String) {
    SCHEDULE("schedule"),
    AWAY("away"),
    FROST_GUARD("frost_guard"),
    MANUAL("manual"),
    MAX("max"),
    OFF("off"),
    HG("hg"),
    UNKNOWN("unknown")
}