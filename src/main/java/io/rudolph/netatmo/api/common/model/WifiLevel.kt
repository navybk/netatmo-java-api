package io.rudolph.netatmo.api.common.model

enum class WifiLevel(val value: String) {
    BAD("bad"),
    AVERAGE("average"),
    GOOD("good"),
    NO_DATA("");

    companion object {
        internal fun wifiLevelForSignalStrength(signal: Int?) =
                signal?.let {
                    when {
                        it >= 86 -> BAD
                        it <= 56 -> GOOD
                        else -> AVERAGE
                    }
                } ?: NO_DATA
    }
}