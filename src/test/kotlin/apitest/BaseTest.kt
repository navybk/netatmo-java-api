package apitest

import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.oauth2.model.Scope

abstract class BaseTest(scope: List<Scope> = listOf()) {

    /**
     * for tests save credentials as json at /src/main/resources
     */
    private val testConfig = TestConfig.buildFromFile("/credentials_app_original.json")
            ?: throw IllegalStateException("config file missing")

    private val userConfig = TestConfig.buildFromFile("/credentialsmicha.json")
            ?: throw IllegalStateException("config file missing")


    protected val api = NetatmoApi(
            clientId = testConfig.clientId,
            clientSecret = testConfig.clientSecret,
            userMail = userConfig.userMail,
            userPassword = userConfig.userPassword,
            scope = scope,
            accessToken = userConfig.accessToken,
            refreshToken = userConfig.refreshToken,
            debug = true
    )
}