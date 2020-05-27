package io.rudolph.netatmo.api.common.model


object Constant {
    const val VALVE_API_STRING = "NRV"
    const val RELAY_API_STRING = "NAPlug"
    const val INDOOR_CAMERA_API_STRING = "NACamera"
    const val INDOOR_SIRENE_API_STRING = "NIS"
    const val OUTDOOR_CAMERA_API_STRING = "NOC"
    const val SMOKEDETECTOR_API_STRING = "NSD"
    const val DOOR_AND_WINDOW_SENSOR_API_STRING = "NACamDoorTag"
    const val BASESTATION_API_STRING = "NAMain"
    const val OUTDOORMODULE_API_STRING = "NAModule1"
    const val WINDMODULE_API_STRING = "NAModule2"
    const val RAINGAUGEMODULE_API_STRING = "NAModule3"
    const val INDOORMODULE_API_STRING = "NAModule4"
    const val THERMOSTAT_API_STRING = "NATherm1"
    const val HOMECOACH_API_STRING = "NHC"
    const val CAM_DOOR_TAG_API_STRING = "NACamDoorTag"
    const val UNKNOWN_API_STRING = "unknown"
}

enum class DeviceType(val value: String) {
    VALVE(Constant.VALVE_API_STRING),
    RELAY(Constant.RELAY_API_STRING),
    HOMECOACH(Constant.HOMECOACH_API_STRING),
    INDOOR_CAMERA(Constant.INDOOR_CAMERA_API_STRING),
    OUTDOOR_CAMERA(Constant.OUTDOOR_CAMERA_API_STRING),
    SMOKEDETECTOR(Constant.SMOKEDETECTOR_API_STRING),
    DOOR_AND_WINDOW_SENSOR(Constant.DOOR_AND_WINDOW_SENSOR_API_STRING),
    BASESTATION(Constant.BASESTATION_API_STRING),
    OUTDOORMODULE(Constant.OUTDOORMODULE_API_STRING),
    WINDMODULE(Constant.WINDMODULE_API_STRING),
    RAINGAUGEMODULE(Constant.RAINGAUGEMODULE_API_STRING),
    INDOORMODULE(Constant.INDOORMODULE_API_STRING),
    THERMOSTAT(Constant.THERMOSTAT_API_STRING),
    CAMDOORTAG(Constant.CAM_DOOR_TAG_API_STRING),
    INDOOR_SIRENE(Constant.INDOOR_SIRENE_API_STRING),
    UNKNOWN(Constant.UNKNOWN_API_STRING);
}