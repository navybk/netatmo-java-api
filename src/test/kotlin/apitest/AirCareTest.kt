package apitest

import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class AirCareTest : BaseTest(listOf(Scope.READ_HOMECOACH)) {

    val connector = api.airCareConnector

    @Test
    fun getPublicData() {
        connector.getHomeCoachsData().executeSync().apply {
            assert(this != null)
        }
    }

}