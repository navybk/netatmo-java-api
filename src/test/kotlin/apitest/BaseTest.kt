package apitest

import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test
import java.time.LocalDateTime


class BaseTest {

    /**
     * for tests save credentials as json at /src/main/resources
     */
    private val testConfig = TestConfig.buildFromFile("/credentials.json") ?: throw IllegalStateException("config file missing")
    private val api = NetatmoApi(
            clientId = testConfig.clientId,
            clientSecret = testConfig.clientSecret,
            userMail = testConfig.userMail,
            userPassword = testConfig.userPassword,
            scope = listOf(Scope.WRITE_THERMOSTAT, Scope.READ_THERMOSTAT),
            accessToken= testConfig.accessToken,
            refreshToken = testConfig.refreshToken,
            debug = true
    )

    @Test
    fun testApi() {
        api.energyApi.getHomesData().apply {
            assert(this != null)
        }?.body?.homes?.get(0)?.id?.apply homeid@{
            api.energyApi.getHomeStatus(this).apply {
                this?.body?.home?.rooms?.get(0)?.apply {
                    val begin = LocalDateTime.parse("2018-01-01T00:00:00")

                    api.energyApi.getRoomMeasure(homeId = this@homeid,
                            roomId = id,
                            scale = "1day",
                            dateBegin = begin,
                            dateEnd = LocalDateTime.now()
                    ).apply {
                        assert(this != null)
                    }

                } ?: apply {
                    assert(false)
                    return
                }
                return
            }
        }
        assert(false)
    }
}