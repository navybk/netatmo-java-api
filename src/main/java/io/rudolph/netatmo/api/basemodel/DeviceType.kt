package io.rudolph.netatmo.api.basemodel


enum class DeviceType(val value: String) {
    NATherm1("thermostat"),
    VALVE("NRV"),
    RELAY("NAPlug"),
    WELCOME_CAMERA("NACamera"),
    PRESENCE_CAMERA("NOC"),
    BASESTATION("NAMain"),
    OUTDOORMODULE("NAModule1"),
    WINDMODULE("NAModule2"),
    RAINGAUGEMODULE("NAModule3"),
    INDOORMODULE("NAModule4"),
    NAPLUG("NAPlug"),
    THERMOSTAT("NATherm1"),
    UNKNOWN("unknown");
}