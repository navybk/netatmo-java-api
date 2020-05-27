package apitest

import com.fasterxml.jackson.core.type.TypeReference
import io.rudolph.netatmo.JacksonTransform
import io.rudolph.netatmo.api.energy.model.TypedBaseResult
import io.rudolph.netatmo.api.security.model.Events
import io.rudolph.netatmo.api.security.model.SecurityHomeData
import io.rudolph.netatmo.api.security.model.pushevent.*
import io.rudolph.netatmo.oauth2.model.Scope
import org.junit.Test

class SecurityTest : BaseTest(listOf(Scope.READ_CAMERA,
        Scope.WRITE_CAMERA,
        Scope.READ_PRESENCE,
        Scope.ACCESS_PRESENCE,
        Scope.ACCESS_CAMERA,
        Scope.READ_SMOKEDETECTOR)) {

    private val connector = api.securityApi

    @Test
    fun parse() {
        readFileForClass<TypedBaseResult<SecurityHomeData>>("apiresults/security/getPublicData.json")!!
        readFileForClass<TypedBaseResult<SecurityHomeData>>("apiresults/security/getHomeData.json")!!
                .apply {
                    this.body!!.homes!!.getOrNull(0)!!
                }
        readFileForClass<TypedBaseResult<Events>>("apiresults/security/getEventsUntil.json")!!
        readFileForClass<TypedBaseResult<Events>>("apiresults/security/getLastEventOf.json")!!
        readFileForClass<TypedBaseResult<Events>>("apiresults/security/getNextEvents.json")!!
    }

    @Test
    fun parsePushEvents() {
        val list: List<PushEvent> = listOf(
                readFileForClass<IndoorCameraConnectedPushEvent>("apiresults/security/pushevent/indoorCameraConnectedPushEvent.json")!!,
                readFileForClass<IndoorCameraMovementPushEvent>("apiresults/security/pushevent/indoorCameraMovementPushEvent.json")!!,
                readFileForClass<IndoorCameraOnOffPushEvent>("apiresults/security/pushevent/indoorCameraOffPushEvent.json")!!,
                readFileForClass<IndoorCameraOnOffPushEvent>("apiresults/security/pushevent/indoorCameraOnPushEvent.json")!!,
                readFileForClass<IndoorCameraPersonPushEvent>("apiresults/security/pushevent/indoorCameraPersonPushEvent.json")!!,
                readFileForClass<OutdoorCameraHumanPushEvent>("apiresults/security/pushevent/outdoorCameraHumanPushEvent.json")!!,
                readFileForClass<SmokeAlarmPushEvent>("apiresults/security/pushevent/smokePushEvent.json")!!
        )
        assert(list.size == 7)
    }

    @Test
    fun convertPushEvent() {
        val stream = TestConfig::class.java.getResource("apiresults/security/pushevent/indoorCameraConnectedPushEvent.json").readText()
        val event = api.convertToPushEvent(stream)!!
        assert(event.userId == "5c81004fd6e33f0b008b45f4")
    }

    @Test
    fun getLastEventOf() {
        val id = api.securityApi.getHomeData()
                .executeSync()!!
                .homes!!
                .first()
                .id!!
        api.securityApi.getLastEventOf(id, "").executeSync()!!
    }

    @Test
    fun getPublicData() {
        connector.getHomeData().executeSync()!!
    }

    @Test
    fun liveSnapshotURLTest() {
        val stream = SecurityTest::class.java.getResourceAsStream("apiresults/security/getPublicData.json").bufferedReader()
        val res = JacksonTransform.mapper
                .readValue(stream, object : TypeReference<TypedBaseResult<SecurityHomeData>>() {})
                .body!!
        connector.getHomeData().executeSync()!!
        val camera = res.homes!![0].cameras!![0]
        assert(camera.vpnUrl == "https://v8.netatmo.net/restricted/10.255.10.199/0abcdefghijklmno_pqrstuvwxyz1,")
    }
}