package apitest

import io.rudolph.netatmo.api.common.model.Scale
import io.rudolph.netatmo.api.common.model.ScaleType
import io.rudolph.netatmo.api.energy.model.HomeStatusBody
import io.rudolph.netatmo.executable.Executable
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test
import java.time.LocalDateTime
import java.util.concurrent.CountDownLatch


class EnergyTest : BaseTest(listOf(Scope.WRITE_THERMOSTAT, Scope.READ_THERMOSTAT)) {

    @Test
    fun testAsyncHomeData() {

        val waitForeverLatch = CountDownLatch(1)

        var result = false

        // First with lambda
        api.energyApi
                .getHomesData()
                .onError {
                    waitForeverLatch.countDown()
                }
                .executeAsync {

                    // second with callback interface
                    api.energyApi.getHomeStatus(it.homes[0].id)
                            .executeAsync(object : Executable.Callback<HomeStatusBody> {
                                override fun onResult(value: HomeStatusBody) {
                                    result = true
                                    waitForeverLatch.countDown()
                                }

                                override fun onError(error: String) {
                                    println(error)

                                    waitForeverLatch.countDown()
                                }

                            })
                }

        waitForeverLatch.await()
        assert(result)
    }

    @Test
    fun testGetHomeStatus() {
        api.energyApi.getHomesData().executeSync().apply {
            assert(this != null)
        }?.homes
                ?.get(0)
                ?.id
                ?.apply homeid@{
                    api.energyApi
                            .getHomeStatus(this)
                            .executeSync().apply {
                                assert(this != null)
                                return
                            }
                }

        assert(false)
    }

    @Test
    fun gestMeasure() {
        api.energyApi.getHomesData().executeSync().apply {
            assert(this != null)
        }?.homes
                ?.get(0)
                ?.apply {
                    val moduleId = modules[1].id!!
                    val deviceId = modules[0].id!!
                    api.energyApi
                            .getMeasure(moduleId = moduleId,
                                    deviceId = deviceId,
                                    scale = Scale.DAY,
                                    type = ScaleType.MIN_TEMP
                            ).executeSync()
                            .apply {
                                assert(this != null)
                            }
                }
    }

    @Test
    fun testGetRoomMeasure() {
        api.energyApi.getHomesData().executeSync().apply {
            assert(this != null)
        }
                ?.homes
                ?.get(0)
                ?.apply {
                    val roomId = this.rooms[0].id ?: run {
                        assert(false)
                        return
                    }

                    val begin = LocalDateTime.parse("2018-01-01T00:00:00")

                    api.energyApi.getRoomMeasure(homeId = this.id,
                            roomId = roomId,
                            scale = "1day",
                            dateBegin = begin,
                            dateEnd = LocalDateTime.now()
                    )
                            .executeSync()
                            .apply {
                                assert(this != null)
                                return
                            }

                }
        assert(false)
    }

    @Test
    fun testCreateAndSyncAndRenameAnddDeleteSchedule() {
        api.energyApi.getHomesData().executeSync().apply {
            assert(this != null)
        }?.homes?.get(0)?.apply {

            val zones = thermSchedules[0].zones
            val timetable = schedules[0].timetable
            val name = "test"
            val hgTRemp = 8F
            val awayTemp = 16F
            val homeId = id
            api.energyApi.createNewHomeSchedule(homeId = homeId,
                    awayTemp = awayTemp,
                    hgTemp = hgTRemp,
                    name = name,
                    timeTable = timetable,
                    zones = zones
            ).executeSync()
                    .apply {
                        val scheduleId = this?.scheduleId!!
                        var result = true
                        api.energyApi.syncHomeSchedule(
                                scheduleId = scheduleId,
                                timeTable = timetable,
                                zones = zones,
                                hgTemp = 12.5F,
                                homeId = homeId,
                                awayTemp = 7F,
                                name = name)
                                .executeSync()
                                .apply {
                                    if (this?.status != "ok") {
                                        result = false
                                    }
                                }

                        api.energyApi
                                .renameHomeSchedule(scheduleId, "test2", homeId)
                                .executeSync()
                                .apply {
                                    if (this?.status != "ok") {
                                        result = false
                                    }
                                }

                        api.energyApi
                                .deleteHomeSchedule(scheduleId, homeId)
                                .executeSync()
                                .apply {
                                    assert(result && this?.status == "ok")
                                    return
                                }

                        return
                    }
        }
        assert(false)
    }
}