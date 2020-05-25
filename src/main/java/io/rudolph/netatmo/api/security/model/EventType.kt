package io.rudolph.netatmo.api.security.model

import io.rudolph.netatmo.api.security.model.Product.*

enum class EventType(val value: String,
                     val products: List<Product>) {
    /**
     * When the Indoor Camera detects a face
     */
    PERSON("person", listOf(INDOOR_CAMERA)),

    /**
     * When geofencing indicates that the person has left the home
     */
    PERSON_AWAY("person_away", listOf(INDOOR_CAMERA)),

    /**
     * When the Indoor Camera detects motion
     */
    MOVEMENT("movement", listOf(INDOOR_CAMERA)),

    /**
     * A new Module has been paired with the Indoor Camera
     */
    NEW_MODULE("new_module", listOf(INDOOR_CAMERA)),

    /**
     * Module is connected with the Indoor Camera
     */
    MODULE_CONNECT("module_connect", listOf(INDOOR_CAMERA)),

    /**
     * Module lost its connection with the Indoor Camera
     */
    MODULE_DISCONNECT("module_disconnect", listOf(INDOOR_CAMERA)),

    /**
     * Module's battery is low
     */
    MODULE_LOW_BATTERY("module_low_battery", listOf(INDOOR_CAMERA)),

    /**
     * EnergyModule's firmware update is over
     */
    MODULE_END_UPDATE("module_end_update", listOf(INDOOR_CAMERA)),

    /**
     * When the camera connects to Netatmo servers
     */
    CONNECTION("connection", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When the camera loses connection to Netatmo servers
     */
    DISCONNECTION("disconnection", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When Camera Monitoring is resumed
     */
    ON("on", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When Camera Monitoring is turned off
     */
    OFF("off", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When the Camera is booting
     */
    BOOT("boot", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When Camera SD Card status changes
     */
    SD("SD", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When Camera power supply status changes
     */
    ALIM("alim", listOf(INDOOR_CAMERA, OUTDOOR_CAMERA)),

    /**
     * When the Outdoor Camera detects a human, a car or an animal
     */
    OUTDOOR("outdoor", listOf(OUTDOOR_CAMERA)),

    /**
     * Event triggered when the video summary of the last 24 hours is available
     */
    DAILY_SUMMARY("daily_summary", listOf(OUTDOOR_CAMERA)),

    /**
     * When a Smart Sensor detects a big move
     */
    TAG_BIG_MOVE("tag_big_move", listOf(INDOOR_CAMERA, DOOR_TAG)),

    /**
     * When a Smart Sensor detects a small move
     */
    TAG_SMALL_MOVE("tag_small_move", listOf(INDOOR_CAMERA, DOOR_TAG)),

    /**
     * When a Smart Sensor was uninstalled
     */
    TAG_UNINSTALLED("tag_uninstalled", listOf(INDOOR_CAMERA, DOOR_TAG)),

    /**
     * When a Smart Sensor detects that a door/window was left open
     */
    TAG_OPEN("tag_open", listOf(INDOOR_CAMERA, DOOR_TAG)),

    /**
     * When the smoke detection is activated or deactivated
     */
    HUSH("hush", listOf(SMOKE_DETECTOR)),

    /**
     * When smoke is detected or smoke is cleared
     */
    SMOKE("smoke", listOf(SMOKE_DETECTOR)),

    /**
     * When smoke detector is ready or tampered
     */
    TAMPERED("tampered", listOf(SMOKE_DETECTOR)),

    /**
     * When wifi status is updated
     */
    WIFI_STATUS("wifi_status", listOf(SMOKE_DETECTOR)),

    /**
     * When battery status is too low
     */
    BATTERY_STATUS("battery_status", listOf(SMOKE_DETECTOR)),

    /**
     * When the detection chamber is dusty or clean
     */
    DETECTION_CHAMBER_STATUS("detection_chamber_status", listOf(SMOKE_DETECTOR)),

    /**
     * Sound test result
     */
    SOUND_TEST("sound_test", listOf(SMOKE_DETECTOR)),

    /**
     * Unkown event
     */
    UNKNOWN("unknown", listOf());
}