package io.rudolph.netatmo.energy.model


enum class ThermMode(val value: String) {
    SCHEDULE("schedule"),
    AWAY("away"),
    FROST_GUARD("frost_guard"),
    UNKNOWN("unknown")
}