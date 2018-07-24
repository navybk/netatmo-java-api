package io.rudolph.netatmo.api.energy.model

enum class ZoneType(val value: Int) {
    // custom Type
    INVALID(-1),

    DAY(0),
    NIGHT(1),
    AWAY(2),
    FROST_GUARD(3),
    CUSTOM(4),
    ECO(5),

    //TODO Check if this is an documentation error in https://dev.netatmo.com/resources/technical/reference/energy/synchomeschedule
    COMFORT(5),
    WHAT (8)
}