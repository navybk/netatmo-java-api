package apitest

import com.fasterxml.jackson.core.type.TypeReference
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.presence.model.SecurityHome
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class PresenceTest : BaseTest(listOf(Scope.READ_CAMERA, Scope.ACCESS_CAMERA, Scope.READ_PRESENCE, Scope.ACCESS_PRESENCE)) {

    val connector = api.presenceApi

    @Test
    fun getPublicData() {
        connector.getHomeData().executeSync().apply {
            assert(this != null)
        }
    }

    @Test
    fun liveSnapshotURLTest() {
        val stream = PresenceTest::class.java.getResourceAsStream("/apiresults/presence/getPublicData.json").bufferedReader()
        val res = JacksonTransform.mapper.readValue<TypedBaseResult<SecurityHome>>(stream, object : TypeReference<TypedBaseResult<SecurityHome>>() {}).body!!
        val result = connector.getHomeData().executeSync()!!
        val camera = res.homes!![0].cameras!![0]
        val url = connector.getLiveSnapshotUrl(camera)!!
    }
}