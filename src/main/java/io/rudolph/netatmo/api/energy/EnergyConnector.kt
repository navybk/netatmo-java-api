package io.rudolph.netatmo.api.energy

import io.rudolph.netatmo.api.common.CommonConnector
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.energy.model.*
import io.rudolph.netatmo.api.energy.service.EnergyService
import io.rudolph.netatmo.executable
import io.rudolph.netatmo.executable.Executable
import io.rudolph.netatmo.oauth2.toTimestamp
import retrofit2.Retrofit
import java.time.LocalDateTime


class EnergyConnector(api: Retrofit) : CommonConnector(api) {
    private val energyService = api.create(EnergyService::class.java)

    /**
     * Retrieve user's homes and their topology.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/homesdata)
     *
     * @param homeId Id of the home
     * @param gatewayTypes Array of desired gateway. For Energy app, use NAPlug
     * @return an executable object to obtain the [HomesDataBody]
     */
    fun getHomesData(homeId: String? = null,
                     gatewayTypes: List<DeviceType>? = null): Executable<TypedBaseResult<HomesDataBody>> {
        return energyService.getHomeData(homeId, gatewayTypes?.toMutableList())
                .executable
    }

    /**
     * Get the current status and data measured for all home devices.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/homestatus)
     *
     * @param homeId id of home
     * @param deviceTypes Array of device type
     * @return The requested [HomeStatusBody] or null
     */
    fun getHomeStatus(homeId: String,
                      deviceTypes: List<DeviceType>? = null): Executable<TypedBaseResult<HomeStatusBody>> {
        return energyService.getHomeStatus(homeId, deviceTypes?.toMutableList())
                .executable
    }

    /**
     * Retrieve data from a Room
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/getroommeasure)
     *
     * @param homeId id of home
     * @param roomId id of room
     * @param scale step between measurements (e.g. max or 1day or 1week)
     * @param temperatureType type of requested measurements
     * @param dateBegin Timestamp of the first measure to retrieve. Default is null.
     * @param dateEnd Timestamp of the last measure to retrieve (default and max are 1024). Default is null.
     * @param limit Maximum number of measurements (default and max Are 1024)
     * @param optimize Determines the format of the answer. Default is true. For mobile apps we recommend True and False if bandwidth isn't an issue as it is easier to parse.
     * @param realTime If scale different than max, timestamps are by default offset + scale/2. To get exact timestamps, use true. Default is false
     * @return The requested [RoomMeasure] or null
     */
    fun getRoomMeasure(homeId: String,
                       roomId: String,
                       scale: String,
                       temperatureType: TemperatureType = TemperatureType.TEMPERATURE,
                       dateBegin: LocalDateTime? = null,
                       dateEnd: LocalDateTime? = null,
                       limit: Int? = null,
                       optimize: Boolean = false,
                       realTime: Boolean = false): Executable<TypedBaseResult<RoomMeasureBody>> {
        return energyService.getRoomMeasure(homeId,
                roomId,
                scale,
                temperatureType,
                dateBegin.toTimestamp(),
                dateEnd.toTimestamp(),
                limit,
                optimize,
                realTime)
                .executable
    }

    /**
     * Set the home heating system to use schedule / away / frost guard mode
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/setthermmode)
     *
     * @param homeId of home
     * @param thermMode Heating mode
     * @param endTime timestamp
     * @return a [BaseResult] or null
     */
    fun setThermMode(homeId: String,
                     thermMode: Mode,
                     endTime: LocalDateTime? = null): Executable<BaseResult> {
        return energyService.setRoomThermMode(homeId,
                thermMode,
                endTime.toTimestamp())
                .executable
    }

    /**
     * Set a manual temperature to a room. or switch back to home mode
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/setroomthermpoint)
     *
     * @param homeId id of home
     * @param roomId id of room
     * @param mode The mode you are applying to this room
     * @param temperature Manual temperature to apply
     * @param endTime End of this manual setpoint
     * @return a [BaseResult] or null
     */
    fun setRoomThermPoint(homeId: String,
                          roomId: String,
                          mode: ThermPointMode,
                          temperature: Float? = null,
                          endTime: LocalDateTime? = null): Executable<BaseResult> {
        return energyService.setRoomThermPoint(homeId,
                roomId,
                mode,
                temperature,
                endTime.toTimestamp())
                .executable
    }

    /**
     * Apply a specific schedule
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/switchhomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param homeId id of home
     * @return a [BaseResult] or null
     */
    fun switchHomeSchedule(scheduleId: String, homeId: String): Executable<BaseResult> {
        return energyService.setSwitchHomeSchedule(scheduleId, homeId)
                .let { Executable(it) }
    }


    /**
     * Modify the given schedule for the home. If it's the current schedule, it sends the modification to the devices.
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/synchomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param timeTable Array describing the timetable.
     * @param zones array of zones object
     * @param name Name you want to apply
     * @param homeId Home to be updated
     * @param hgTemp Frost guard temperature value
     * @param awayTemp Away temperature value
     * @return a [BaseResult] or null
     */
    fun syncHomeSchedule(scheduleId: String,
                         timeTable: List<Timetable>,
                         zones: List<Zone>,
                         name: String,
                         homeId: String,
                         hgTemp: Float,
                         awayTemp: Float): Executable<BaseResult> {

        val body = SetHomeScheduleBody(scheduleId,
                timeTable,
                zones,
                name,
                homeId,
                hgTemp,
                awayTemp)
        return energyService.setSyncHomeSchedule(body)
                .executable
    }

    /**
     * Update the given schedule name
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/renamehomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param name Name you want to apply
     * @param homeId id of home
     * @return a [BaseResult] or null
     */
    fun renameHomeSchedule(scheduleId: String,
                           name: String,
                           homeId: String): Executable<BaseResult> {
        return energyService.postRenameHomeSchedule(scheduleId, name, homeId).executable
    }

    /**
     * Delete the given schedule
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/deletehomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param homeId id of home
     * @return a [BaseResult] or null
     */
    fun deleteHomeSchedule(scheduleId: String,
                           homeId: String): Executable<BaseResult> {
        return energyService.deleteHomeSchedule(scheduleId, homeId).executable
    }

    /**
     * Update the given schedule name
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energy/createnewhomeschedule)
     *
     * @param homeId Id of the home
     * @param timeTable Array of timetable
     * @param zones Array of zones
     * @param name Schedule name
     * @param hgTemp Frost Guard temperature value
     * @param awayTemp Away temperature value
     * @return a [BaseResult] or null
     */
    fun createNewHomeSchedule(homeId: String,
                              timeTable: List<Timetable>,
                              zones: List<Zone>,
                              name: String,
                              hgTemp: Float,
                              awayTemp: Float): Executable<TypedBaseResult<CreateNewHomeScheduleResponse>> {
        val body = CreateNewHomeScheduleBody(homeId,
                timeTable.toMutableList(),
                zones.toMutableList(),
                name,
                hgTemp,
                awayTemp)
        return energyService.createNewHomeSchedule(body)
                .executable
    }


}