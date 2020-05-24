package apitest

import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class AirCareTest : BaseTest(listOf(Scope.READ_HOMECOACH)) {

    private val connector = api.airCareApi

    @Test
    fun getPublicData() {
        connector.getHomeCoachData()
                .executeSync()
                .apply {
                    assert(this != null)
                }
    }

    @Test
    fun parsingTest() {
        readFileForClass<TypedBaseResult<StationResults>>("apiresults/aircare/getHomeCoachLive.json")!!
        readFileForClass<TypedBaseResult<StationResults>>("apiresults/aircare/gethomecoachsdata.json")!!
    }

}