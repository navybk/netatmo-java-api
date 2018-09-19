package apitest

import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.oauth2.model.Scope

abstract class BaseTest(scope: List<Scope> = listOf()) {

    /**
     * for tests save credentials as json at /src/main/resources and run task "copyTestResources"
     * after changes OR create a custom object
     */
    private val testConfig = TestConfig.buildFromFile("credentialsmicha.json")
            ?: throw IllegalStateException("config file missing")

    protected val api = NetatmoApi(
            clientId = testConfig.clientId,
            clientSecret = testConfig.clientSecret,
            userMail = testConfig.userMail,
            userPassword = testConfig.userPassword,
            scope = scope,
            accessToken = testConfig.accessToken,
            refreshToken = testConfig.refreshToken,
            debug = true
    )

}