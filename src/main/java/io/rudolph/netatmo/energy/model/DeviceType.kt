package io.rudolph.netatmo.energy.model


enum class DeviceType(val value: String) {
    NATherm1("thermostat"),
    VALVE("NRV"),
    RELAY("NAPlug"),
    WELCOME_CAMERA("NACamera"),
    PRESENCE_CAMERA("NOC"),
    UNKNOWN("unknown");
}