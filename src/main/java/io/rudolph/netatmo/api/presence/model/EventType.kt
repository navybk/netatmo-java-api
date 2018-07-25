package io.rudolph.netatmo.api.presence.model

enum class EventType(val value: String, val product: List<String>) {
    /**
     * Event triggered when Welcome detects a face
     */
    PERSON("Person", listOf("Welcome")),

    /**
     * Event triggered when geofencing implies the person has left the home
     */
    PERSON_AWAY("Person_away", listOf("Welcome")),

    /**
     * Event triggered when Welcome detects a motion
     */
    MOVEMENT("Movement", listOf("Welcome")),

    /**
     * Event triggered when Presence detects a human, a car or an animal
     */
    OUTDOOR("Outdoor", listOf("Presence")),

    /**
     * When the camera connects to Netatmo servers
     */
    CONNECTION("Connection", listOf("Welcome", "Presence")),

    /**
     * When the camera loses connection to Netatmo servers
     */
    DISCONNECTION("Disconnection", listOf("Welcome", "Presence")),

    /**
     * Whenever monitoring is activated
     */
    ON("On", listOf("Welcome", "Presence")),

    /**
     * Whenever monitoring is suspended
     */
    OFF("Off", listOf("Welcome", "Presence")),

    /**
     * When the camera is booting
     */
    BOOT("Boot", listOf("Welcome", "Presence")),

    /**
     * Event triggered by the SD card status change
     */
    SD("SD", listOf("Welcome", "Presence")),

    /**
     * Event triggered by the power supply status change
     */
    ALIM("Alim", listOf("Welcome", "Presence")),

    /**
     * Event triggered when the video summary of the last 24 hours is available
     */
    DAILY_SUMMARY("daily_summary", listOf("Presence")),

    /**
     * A new module has been paired with Welcome
     */
    NEW_MODULE("new_module", listOf("Welcome")),

    /**
     * Module is connected with Welcome (after disconnection)
     */
    MODULE_CONNECT("module_connect", listOf("Welcome")),

    /**
     * Module lost its connection with Welcome
     */
    MODULE_DISCONNECT("module_disconnect", listOf("Welcome")),

    /**
     * Module's battery is low
     */
    MODULE_LOW_BATTERY("module_low_battery", listOf("Welcome")),

    /**
     * Module's firmware update is over
     */
    MODULE_END_UPDATE("module_end_update", listOf("Welcome")),

    /**
     * Tag detected a big move
     */
    TAG_BIG_MOVE("tag_big_move", listOf("Welcome")),

    /**
     * Tag detected a small move
     */
    TAG_SMALL_MOVE("tag_small_move", listOf("Welcome")),

    /**
     * Tag was uninstalled
     */
    TAG_UNINSTALLED("tag_uninstalled", listOf("Welcome")),

    /**
     * Tag detected the door/window was left open
     */
    TAG_OPEN("tag_open", listOf("Welcome")),

    /**
     * Unkown event
     */
    UNKNOWN("unknown", listOf())
}