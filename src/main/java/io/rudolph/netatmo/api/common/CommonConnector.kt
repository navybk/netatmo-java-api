package io.rudolph.netatmo.api.common

import io.rudolph.netatmo.api.common.model.MeasureRequestResponse
import io.rudolph.netatmo.api.common.model.Scale
import io.rudolph.netatmo.api.common.model.ScaleType
import io.rudolph.netatmo.api.common.service.CommonService
import io.rudolph.netatmo.executable.BodyResultExecutable
import io.rudolph.netatmo.oauth2.toTimestamp
import retrofit2.Retrofit
import java.time.LocalDateTime


abstract class CommonConnector(api: Retrofit) {
    private val apiService = api.create(CommonService::class.java)

    /**
     * Retrieve data from a device or module (Weather station and Thermostat only).
     *
     * required scope: read_station read_thermostat
     *
     * @see [Netatmo Api Reference] (https://dev.netatmo.com/resources/technical/reference/common/getmeasure)
     *
     * @param moduleId Mac address of the module you’re interested in. If not specified, returns data of the device. If specified, returns data from the specified module.
     * @param deviceId Mac address of the device (can be found via getuser)
     * @param scale Timelapse between two measurements
     * @param type Measures you are interested in. Data you can request depends on the scale. See full details
     * @param dateBegin Timestamp of the first measure to retrieve. Default is null.
     * @param dateEnd Timestamp of the last measure to retrieve (default and max are 1024). Default is null.
     * @param limit Maximum number of measurements (default and max are 1024)
     * @param optimize Determines the format of the answer. Default is true. For mobile apps we recommend True and False if bandwidth isn't an issue as it is easier to parse.
     * @param realTime If scale different than max, timestamps are by default offset + scale/2. To get exact timestamps, use true. Default is false.
     * @return an executable object to obtain a list of [MeasureRequestResponse]
     */
    fun getMeasure(
            moduleId: String,
            deviceId: String,
            scale: Scale,
            type: ScaleType,
            dateBegin: LocalDateTime? = null,
            dateEnd: LocalDateTime? = null,
            limit: Int? = null,
            optimize: Boolean? = null,
            realTime: Boolean? = null
    ): BodyResultExecutable<List<MeasureRequestResponse>> {
        return BodyResultExecutable {
            apiService.getMeasure(
                    accessToken = "empty",
                    moduleId = moduleId,
                    deviceId = deviceId,
                    scale = scale.value,
                    type = type.value,
                    dateBegin = dateBegin.toTimestamp(),
                    dateEnd = dateEnd.toTimestamp(),
                    limit = limit,
                    optimize = optimize,
                    realTime = realTime)
        }
    }
}