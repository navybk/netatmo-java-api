package apitest

import org.junit.Test

class WeatherTest : BaseTest() {

    val connector = api.weatherApi

    @Test
    fun getPublicData() {
        connector.getPublicData(
                latitudeNorthEast = 10F,
                longitudeNorthEast = 10F,
                latitudeSouthWest = -10F,
                longitudeSouthWest = -10F)
                .executeSync().apply {
                    assert(this != null)
                }
    }

    @Test
    fun getStationData() {
        connector.getStationData().executeSync().apply {
            assert(this != null)
        }
    }

}