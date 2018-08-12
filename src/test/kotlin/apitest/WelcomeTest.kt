package apitest

import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class WelcomeTest : BaseTest(listOf(Scope.READ_CAMERA,
        Scope.WRITE_CAMERA,
        Scope.READ_PRESENCE,
        Scope.ACCESS_PRESENCE)) {


    @Test
    fun getLastEventOf() {
        api.welcomeApi.getLastEventOf("", "").executeSync().apply {
            assert(this != null)
        }
    }
}