package io.rudolph.netatmo.energy

import io.rudolph.netatmo.energy.model.*
import io.rudolph.netatmo.energy.service.EnergyService
import io.rudolph.netatmo.oauth2.toTimestamp
import retrofit2.Retrofit
import java.time.LocalDateTime


class EnergyApi(api: Retrofit) {
    private val energyService = api.create(EnergyService::class.java)

    fun getHomesData(): HomesData? {
        return energyService.getHomeData()
                .execute()
                .body()
    }

    fun getHomeStatus(homeId: String, deviceTypes: List<DeviceType>? = null): HomeStatus? {
        return energyService.getHomeStatus(homeId, deviceTypes?.toMutableList())
                .execute()
                .body()
    }

    /**
     * Retrieve data from a Room
     *
     * @param homeId
     * @param roomId
     * @param scale
     * @param temperatureType
     * @param dateBegin
     * @param dateEnd
     * @param limit
     * @param optimize
     * @param realTime
     */
    fun getRoomMeasure(homeId: String,
                       roomId: String,
                       scale: String,
                       temperatureType: TemperatureType = TemperatureType.TEMPERATURE,
                       dateBegin: LocalDateTime? = null,
                       dateEnd: LocalDateTime? = null,
                       limit: Int? = null,
                       optimize: Boolean = false,
                       realTime: Boolean = false): RoomMeasure? {
        return energyService.getRoomMeasure(homeId,
                roomId,
                scale,
                temperatureType,
                dateBegin.toTimestamp(),
                dateEnd.toTimestamp(),
                limit,
                optimize,
                realTime)
                .execute()
                .body()
    }
}