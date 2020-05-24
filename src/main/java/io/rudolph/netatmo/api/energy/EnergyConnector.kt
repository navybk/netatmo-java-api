package io.rudolph.netatmo.api.energy

import io.rudolph.netatmo.api.common.CommonConnector
import io.rudolph.netatmo.api.common.model.DeviceType
import io.rudolph.netatmo.api.common.model.Module
import io.rudolph.netatmo.api.energy.model.*
import io.rudolph.netatmo.api.energy.model.module.EnergyModule
import io.rudolph.netatmo.api.energy.model.module.RelayModule
import io.rudolph.netatmo.api.energy.model.module.ThermostatModule
import io.rudolph.netatmo.api.energy.model.module.ValveModule
import io.rudolph.netatmo.api.energy.service.EnergyService
import io.rudolph.netatmo.executable.BodyResultExecutable
import io.rudolph.netatmo.executable.PlainCallExecutable
import io.rudolph.netatmo.executable.PlainFunctionExecutable
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
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homesdata)
     *
     * @return an executable object to obtain the [HomesDataBody]
     */
    fun getHomesData(): BodyResultExecutable<HomesDataBody> {
        return BodyResultExecutable { energyService.getHomeData() }
    }

    /**
     * Retrieve user's homes and their topology.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homesdata)
     *
     * @param homeId Id of the home
     * @return an executable object to obtain the [HomesDataBody]
     */
    fun getHomesData(homeId: String? = null): BodyResultExecutable<HomesDataBody> {
        return BodyResultExecutable { energyService.getHomeData(homeId) }
    }

    /**
     * Retrieve user's homes and their topology.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homesdata)
     *
     * @param homeId Id of the home
     * @param gatewayTypes Array of desired gateway. For Energy app, use NAPlug
     * @return an executable object to obtain the [HomesDataBody]
     */
    fun getHomesData(homeId: String? = null,
                     gatewayTypes: List<DeviceType>? = null): BodyResultExecutable<HomesDataBody> {
        return BodyResultExecutable {
            energyService.getHomeData(homeId, gatewayTypes?.toMutableList())
        }
    }

    /**
     * Retrieve user's homes and their topology.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homesdata)
     *
     * @param homeId Id of the home
     * @param gatewayType Desired gateway. For Energy app, use NAPlug
     * @return an executable object to obtain the [HomesDataBody]
     */
    fun getHomesData(homeId: String? = null,
                     gatewayType: DeviceType? = null): BodyResultExecutable<HomesDataBody> {
        return BodyResultExecutable {
            energyService.getHomeData(homeId, gatewayType?.let { mutableListOf(gatewayType) })
        }
    }

    /**
     * Get the current status and data measured for all home devices.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homestatus)
     *
     * @param homeId id of home
     * @return The requested [HomeStatusBody] or null
     */
    fun getHomeStatus(homeId: String): BodyResultExecutable<HomeStatusBody> {
        return BodyResultExecutable {
            energyService.getHomeStatus(homeId)
        }
    }

    /**
     * Get the current status and data measured for all home devices.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homestatus)
     *
     * @param homeId id of home
     * @param deviceTypes Array of device type
     * @return The requested [HomeStatusBody] or null
     */
    fun getHomeStatus(homeId: String,
                      deviceTypes: List<DeviceType>? = null): BodyResultExecutable<HomeStatusBody> {
        return BodyResultExecutable {
            energyService.getHomeStatus(homeId, deviceTypes?.toMutableList())
        }
    }

    /**
     * Get the current status and data measured for all home devices.
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/homestatus)
     *
     * @param homeId id of home
     * @param deviceType device type
     * @return The requested [HomeStatusBody] or null
     */
    fun getHomeStatus(homeId: String,
                      deviceType: DeviceType? = null): BodyResultExecutable<HomeStatusBody> {
        return BodyResultExecutable {
            energyService.getHomeStatus(homeId, deviceType?.let { mutableListOf(it) })
        }
    }

    /**
     * Retrieve data from a Room
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/getroommeasure)
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
                       realTime: Boolean = false): BodyResultExecutable<RoomMeasureBody> {
        return BodyResultExecutable {
            energyService.getRoomMeasure(homeId,
                    roomId,
                    scale,
                    temperatureType,
                    dateBegin.toTimestamp(),
                    dateEnd.toTimestamp(),
                    limit,
                    optimize,
                    realTime)
        }
    }

    /**
     * Set the home heating system to use schedule / away / frost guard mode
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/setthermmode)
     *
     * @param homeId of home
     * @param thermMode Heating mode
     * @param endTime timestamp
     * @return a [BaseResult] or null
     */
    fun setThermMode(homeId: String,
                     thermMode: Mode,
                     endTime: LocalDateTime? = null): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            energyService.setRoomThermMode(homeId,
                    thermMode,
                    endTime.toTimestamp())
        }
    }

    /**
     * Set a manual temperature to a room. or switch back to home mode
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/setroomthermpoint)
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
                          endTime: LocalDateTime? = null): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            energyService.setRoomThermPoint(homeId,
                    roomId,
                    mode,
                    temperature,
                    endTime.toTimestamp())
        }
    }

    /**
     * Apply a specific schedule
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/switchhomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param homeId id of home
     * @return a [BaseResult] or null
     */
    fun switchHomeSchedule(scheduleId: String, homeId: String): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            energyService.setSwitchHomeSchedule(scheduleId, homeId)
        }
    }


    /**
     * Modify the given schedule for the home. If it's the current schedule, it sends the modification to the devices.
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/synchomeschedule)
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
                         awayTemp: Float): PlainCallExecutable<BaseResult> {

        val body = SetHomeScheduleBody(scheduleId,
                timeTable,
                zones,
                name,
                homeId,
                hgTemp,
                awayTemp)
        return PlainCallExecutable {
            energyService.setSyncHomeSchedule(body)
        }
    }

    /**
     * Update the given schedule name
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/renamehomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param name Name you want to apply
     * @param homeId id of home
     * @return a [BaseResult] or null
     */
    fun renameHomeSchedule(scheduleId: String,
                           name: String,
                           homeId: String): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            energyService.postRenameHomeSchedule(scheduleId, name, homeId)
        }
    }

    /**
     * Delete the given schedule
     *
     * required scope: write_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/deletehomeschedule)
     *
     * @param scheduleId ID of the schedule to switch on
     * @param homeId id of home
     * @return a [BaseResult] or null
     */
    fun deleteHomeSchedule(scheduleId: String,
                           homeId: String): PlainCallExecutable<BaseResult> {
        return PlainCallExecutable {
            energyService.deleteHomeSchedule(scheduleId, homeId)
        }
    }

    /**
     * Update the given schedule name
     *
     * required scope: read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/energyApi/createnewhomeschedule)
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
                              awayTemp: Float): BodyResultExecutable<CreateNewHomeScheduleResponse> {
        val body = CreateNewHomeScheduleBody(homeId,
                timeTable.toMutableList(),
                zones.toMutableList(),
                name,
                hgTemp,
                awayTemp)
        return BodyResultExecutable {
            energyService.createNewHomeSchedule(body)
        }
    }

    fun getCombinedModule(homeId: String, moduleId: String): PlainFunctionExecutable<Module?> {
        val func = inner@{
            val module = getHomesData(homeId).executeSync()
                    ?.homes
                    ?.find { it.id == homeId }
                    ?.modules
                    ?.find { it.id == moduleId }
                    ?: return@inner null

            getHomeStatus(homeId, module.type).executeSync()
                    ?.homes
                    ?.find { it.id == homeId }
                    ?.modules
                    ?.find { it.id == moduleId }
                    ?.let {
                        when (module) {
                            is ValveModule -> module.join(it as ValveModule)
                            is RelayModule -> module.join(it as RelayModule)
                            is ThermostatModule -> module.join(it as ThermostatModule)
                            else -> module
                        }
                    }
        }
        return PlainFunctionExecutable(func)
    }

    fun getCombinedHome(homeId: String? = null): PlainFunctionExecutable<HomesDataBody?> {
        val func = inner@{
            val origin = getHomesData(homeId).executeSync()
            return@inner origin?.homes
                    ?.mapNotNull { home ->
                        val status = getHomeStatus(home.id).executeSync()
                                ?.homes
                                ?.find { it.id == home.id }
                                ?.modules ?: return@mapNotNull null
                        val modules = home.modules.mapNotNull { module ->
                            status.find { it.id == module.id }
                                    ?.let {
                                        when (module) {
                                            is ValveModule -> module.join(it as ValveModule)
                                            is RelayModule -> module.join(it as RelayModule)
                                            is ThermostatModule -> module.join(it as ThermostatModule)
                                            else -> module
                                        }
                                    }
                        }
                        home.copy(modules = modules)
                    }?.let {
                        origin.copy(homes = it)
                    } ?: origin
        }
        return PlainFunctionExecutable(func)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : EnergyModule<T>> getModuleDataById(homeId: String? = null, moduleId: String): T? {
        getHomesData(homeId = homeId, gatewayType = null).executeSync()
                ?.homes
                ?.forEach { home ->
                    home.modules
                            .find { it.id == moduleId }
                            ?.let { module ->
                                return module as? T
                            }
                }
        return null
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : EnergyModule<T>> getModuleStatus(homeId: String, module: T): T? {
        getHomeStatus(homeId = homeId, deviceType = module.type).executeSync()
                ?.homes
                ?.forEach { home ->
                    home.modules
                            .find { it.id == module.id }
                            ?.let { module ->
                                return module as? T
                            }
                }
        return null
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : EnergyModule<T>> getJoinedModuleForId(homeId: String? = null, moduleId: String): T? {
        getHomesData(homeId = homeId, gatewayType = null).executeSync()
                ?.homes
                ?.forEach { home ->
                    home.modules
                            .find { it.id == moduleId }
                            ?.let {
                                it as? T
                            }
                            ?.let { first ->
                                getModuleStatus(home.id, first)?.let {
                                    first.join(it)
                                }
                            }
                }
        return null
    }

    fun <T : EnergyModule<T>> getJoinedModule(homeId: String, module: T): T? =
            getModuleStatus(homeId, module)?.join(module)

}