package apitest

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
        val result = connector.getHomeData().executeSync()!!
        val camera = result.homes!![0].cameras!![0]
        val url = connector.getLiveSnapshotUrl(camera)!!
    }
}