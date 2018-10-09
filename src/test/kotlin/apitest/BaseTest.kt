package apitest

import com.fasterxml.jackson.core.type.TypeReference
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.NetatmoApi
import io.rudolph.netatmo.oauth2.model.Scope

abstract class BaseTest(scope: List<Scope> = listOf()) {

    /**
     * for tests save credentials as json at /src/main/resources and run task "copyTestResources"
     * after changes OR create a custom object
     */
    private val testConfig = TestConfig.buildFromFile("/credentialsempty.json")
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

    internal inline fun <reified T> readFileForClass(filename: String): T? {
        val stream = TestConfig::class.java.getResourceAsStream(filename).bufferedReader()
        val reference = object : TypeReference<T>() {}
        return JacksonTransform.mapper.readValue(stream, reference)
    }
}