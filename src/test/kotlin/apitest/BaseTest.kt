package apitest

import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test
import java.time.LocalDateTime


class BaseTest {

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
    fun testGetHomeStatus() {
        api.energyApi.getHomesData().executeSync().apply {
            assert(this != null)
        }?.body
                ?.homes
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
    fun testGetRoomMeasure() {
        api.energyApi.getHomesData().executeSync().apply {
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

                    api.energyApi.getRoomMeasure(homeId = homeId,
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
        }?.body?.homes?.get(0)?.apply {

            val zones = thermSchedules?.get(0)?.zones!!
            val timetable = schedules?.get(0)?.timetable!!
            val name = "test"
            val hgTRemp = 8F
            val awayTemp = 16F
            val homeId = id!!
            api.energyApi.createNewHomeSchedule(homeId = homeId,
                    awayTemp = awayTemp,
                    hgTemp = hgTRemp,
                    name = name,
                    timeTable = timetable,
                    zones = zones
            ).executeSync()
                    .apply {
                        val scheduleId = this?.body?.scheduleId!!
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