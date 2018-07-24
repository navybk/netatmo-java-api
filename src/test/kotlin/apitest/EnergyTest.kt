package apitest

import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.api.energy.model.HomesDataBody
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.executable.Executable
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test
import java.time.LocalDateTime
import java.util.concurrent.CountDownLatch


class EnergyTest {

    /**
     * for tests save credentials as json at /src/main/resources
     */
    private val testConfig = TestConfig.buildFromFile("/credentials.json")
            ?: throw IllegalStateException("config file missing")
    private val api = NetatmoApi(
            clientId = testConfig.clientId,
            clientSecret = testConfig.clientSecret,
            userMail = testConfig.userMail,
            userPassword = testConfig.userPassword,
            scope = listOf(Scope.WRITE_THERMOSTAT, Scope.READ_THERMOSTAT),
            accessToken = testConfig.accessToken,
            refreshToken = testConfig.refreshToken,
            debug = true
    )

    @Test
    fun testAsyncHomeData() {

        val waitForeverLatch = CountDownLatch(1)

        var result = false

        // First with lambda
        api.energyApiConnector
                .getHomesData()
                .onError {
                    waitForeverLatch.countDown()
                }
                .executeAsync {

                    // second with callback interface
                    api.energyApiConnector.getHomesData().executeAsync(object : Executable.Callback<TypedBaseResult<HomesDataBody>> {
                        override fun onResult(value: TypedBaseResult<HomesDataBody>) {
                            result = true
                            waitForeverLatch.countDown()
                        }

                        override fun onError(error: String) {
                            waitForeverLatch.countDown()
                        }

                    })
                }

        waitForeverLatch.await()
        assert(result)
    }

    @Test
    fun testGetHomeStatus() {
        api.energyApiConnector.getHomesData().executeSync().apply {
            assert(this != null)
        }?.body
                ?.homes
                ?.get(0)
                ?.id
                ?.apply homeid@{
                    api.energyApiConnector
                            .getHomeStatus(this)
                            .executeSync().apply {
                                assert(this != null)
                                return
                            }
                }

        assert(false)
    }

    @Test
    fun testGetRoomMeasure() {
        api.energyApiConnector.getHomesData().executeSync().apply {
            assert(this != null)
        }?.body
                ?.homes
                ?.get(0)
                ?.apply {
                    val homeId = this.id ?: run {
                        assert(false)
                        return
                    }

                    val roomId = this.rooms?.get(0)?.id ?: run {
                        assert(false)
                        return
                    }

                    val begin = LocalDateTime.parse("2018-01-01T00:00:00")

                    api.energyApiConnector.getRoomMeasure(homeId = homeId,
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
        api.energyApiConnector.getHomesData().executeSync().apply {
            assert(this != null)
        }?.body?.homes?.get(0)?.apply {

            val zones = thermSchedules?.get(0)?.zones!!
            val timetable = schedules?.get(0)?.timetable!!
            val name = "test"
            val hgTRemp = 8F
            val awayTemp = 16F
            val homeId = id!!
            api.energyApiConnector.createNewHomeSchedule(homeId = homeId,
                    awayTemp = awayTemp,
                    hgTemp = hgTRemp,
                    name = name,
                    timeTable = timetable,
                    zones = zones
            ).executeSync()
                    .apply {
                        val scheduleId = this?.body?.scheduleId!!
                        var result = true
                        api.energyApiConnector.syncHomeSchedule(
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

                        api.energyApiConnector
                                .renameHomeSchedule(scheduleId, "test2", homeId)
                                .executeSync()
                                .apply {
                                    if (this?.status != "ok") {
                                        result = false
                                    }
                                }

                        api.energyApiConnector
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