package apitest

import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class WeatherTest {

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
    fun test() {
        api.weatherApiConnector.getPublicData(
                latitudeNorthEast = 10F,
                longitudeNorthEast = 10F,
                latitudeSouthWest = -10F,
                longitudeSouthWest = -10F)
                .executeSync().apply {
                    assert(this != null)
                }
    }
}