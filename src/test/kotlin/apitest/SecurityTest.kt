package apitest

import com.fasterxml.jackson.core.type.TypeReference
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.common.model.StationResults
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.security.model.Events
import io.rudolph.netatmo.api.security.model.SecurityHome
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class SecurityTest : BaseTest(listOf(Scope.READ_CAMERA,
        Scope.WRITE_CAMERA,
        Scope.READ_PRESENCE,
        Scope.ACCESS_PRESENCE,
        Scope.ACCESS_CAMERA)) {

    private val connector = api.securityApi

    @Test
    fun parseEvents() {
        readFileForClass<TypedBaseResult<Events>>("apiresults/security/getLastEventOf.json").apply {
            assert(this != null)
        }

    }

    @Test
    fun getLastEventOf() {
        api.securityApi.getLastEventOf("", "").executeSync().apply {
            assert(this != null)
        }
    }

    @Test
    fun parsingTest() {
        readFileForClass<TypedBaseResult<SecurityHome>>("apiresults/security/getPublicData.json")!!
    }

    @Test
    fun getPublicData() {
        connector.getHomeData().executeSync().apply {
            assert(this != null)
        }
    }

    @Test
    fun liveSnapshotURLTest() {
        val stream = SecurityTest::class.java.getResourceAsStream("apiresults/security/getPublicData.json").bufferedReader()
        val res = JacksonTransform.mapper
                .readValue(stream, object : TypeReference<TypedBaseResult<SecurityHome>>() {})
                .body!!
        connector.getHomeData().executeSync()!!
        val camera = res.homes!![0].cameras!![0]
        assert(camera.vpnUrl == "https://v8.netatmo.net/restricted/10.255.10.199/0abcdefghijklmno_pqrstuvwxyz1,")
    }
}