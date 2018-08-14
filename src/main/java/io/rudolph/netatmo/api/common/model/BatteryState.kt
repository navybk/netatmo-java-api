package io.rudolph.netatmo.api.common.model

import java.util.*

enum class BatteryState(val value: String) {
    MAX("max"),
    FULL("full"),
    HIGH("high"),
    MEDIUM("medium"),
    LOW("low"),
    VERYLOW("very low"),
    NO_DATA("");

    companion object {
        internal val WIND: SortedMap<Int, BatteryState> =
                sortedMapOf(6000 to MAX,
                        5590 to FULL,
                        5180 to HIGH,
                        4770 to MEDIUM,
                        4360 to LOW,
                        0 to VERYLOW)
        internal val RAINGAUGE: SortedMap<Int, BatteryState> =
                sortedMapOf(6000 to MAX,
                        5500 to FULL,
                        5000 to HIGH,
                        4500 to MEDIUM,
                        4000 to LOW,
                        0 to VERYLOW)

        internal val OUTDOOR = RAINGAUGE

        internal val INDOOR: SortedMap<Int, BatteryState> =
                sortedMapOf(6000 to MAX,
                        5640 to FULL,
                        5280 to HIGH,
                        4920 to MEDIUM,
                        4560 to LOW,
                        0 to VERYLOW)
    }
}